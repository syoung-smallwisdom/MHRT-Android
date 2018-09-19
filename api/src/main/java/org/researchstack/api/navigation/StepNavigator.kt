package org.researchstack.api.navigation

import org.researchstack.api.step.Step
import org.researchstack.api.result.collection.TaskResult

/**
 *  `StepNavigator` is used to define the order of presentation of the steps in a task. The
 *  navigator should include navigation that is based on the input model and the results rather
 *  that depending upon the device type.
 * 
 *  @see `Task`, `ConditionalStepNavigator`
 */
interface StepNavigator {

    /**
     *  Returns the step associated with a given identifier.
     *  @param identifier   The identifier for the step.
     *  @return             The step with this identifier or nil if not found.
     */
    fun step(identifier: String): Step?


    /**
     *  Should the task exit early from the entire task including if this navigator is used to run
     *  a subtask.
     *
     *  @param step     The current step.
     *  @param result   The current result set for this task.
     *  @return         `true` if the task view controller should exit.
     */
    fun shouldExitAfter(step: Step?, result: TaskResult): Boolean

    /**
     *  Is there a step after the current step with the given result.
     *
     *  @note the result may not include a result for the current step.
     *
     *  @param step     The current step.
     *  @param result   The current result set for this task.
     *  @return         `true` if the task view controller should show a next button.
     */
    fun hasStepAfter(step: Step?, result: TaskResult): Boolean


    /**
     *  Given the current task result, is there a step before the current step?
     *
     *  This method is checked when first displaying a step to determine if the UI should display
     *  this as the first step.
     *
     *  @note the task result may or may not include a result for the given step.
     *
     *  @param step     The current step.
     *  @param result   The current result set for this task.
     *  @return         `true` if the task view controller should show a back button.
     */
    fun hasStepBefore(step: Step, result: TaskResult): Boolean

    /**
     *  Return the step to go to after the given step.
     *
     *  @param step     The current step (or `null` if this is the first step).
     *  @param result   The current result set for this task.
     *  @return         A step navigation object defining the step, direction, and new task result
     *                  or `null` if this is the last step.
     */
    fun stepAfter(step: Step?, result: TaskResult): StepNavigation?

    /**
     *  Return the step to go to before the given step.
     *
     *  @param step     The current step (or `null` if this is the first step).
     *  @param result   The current result set for this task.
     *  @return         A step navigation object defining the step, direction, and new task result
     *                  or `null` if this is the first step or reverse navigation is blocked.
     */
    fun stepBefore(step: Step, result: TaskResult): StepNavigation?

    /**
     *  Return the progress through the task for a given step with the current result.
     *
     *  @param step     The current step.
     *  @param result   The current result set for this task.
     *  @return         The step progress or `null` if undefined for this navigator.
     */
    fun progress(step: Step, result: TaskResult): StepProgress?
}

/**
 * The direction in which the UI/UX should show navigation. For example, in some cases, a result
 * could give a "looping" style of navigation where the participant is directed backward in the task
 * step order. In this case, the UX might call for a "pop" animation rather than a "push" animation.
 */
enum class NavigatorDirection {
    REVERSE, FORWARD, NONE
}

/**
 * The navigation is a tuple of the step, direction, and (if applicable) the new task result if the
 * navigator mutated the result while evaluating a request to navigate forward or back.
 *
 * @see `StepNavigator`
 */
class StepNavigation(val step: Step,
                     val direction: NavigatorDirection,
                     val newTaskResult: TaskResult? = null)

/**
 * The progress is a tuple of the current step number, total number of steps, and whether or not
 * the progress is estimated because steps can be skipped by this navigator.
 *
 * @see `StepNavigator`
 *
 * @param current       The current progress. This indicates progress within the task.
 * @param total         The total number of steps.
 * @param isEstimated   Whether or not the progress is an estimate (if the task has variable navigation).
 */
class StepProgress(val current: Int,
                   val total: Int,
                   val isEstimated: Boolean)