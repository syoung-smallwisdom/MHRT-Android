package org.researchstack.api.task

import org.researchstack.api.Identifiable
import org.researchstack.api.navigation.StepNavigation
import org.researchstack.api.navigation.StepProgress
import org.researchstack.api.result.collection.TaskResult
import org.researchstack.api.step.Step

/**
 *  `Task` is the interface for running a task. It includes information about how to calculate
 *  progress, validation, and the order of display for the steps.
 */
interface Task : Identifiable {

    /**
     *  Returns the step associated with a given identifier.
     *
     *  @param identifier   The identifier for the step.
     *  @return             The step with this identifier or null if not found or not applicable.
     */
    fun step(identifier: String): Step?

    /**
     *  Should the task exit early from the entire task including if this navigator is used to run a subtask.
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
     *  This method is checked when first displaying a step to determine if the UI should display this as the first
     *  step.
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
     *  @return         A step navigation object defining the step, direction, and added results or `null` if this is
     *                  the last step.
     */
    fun stepAfter(step: Step?, result: TaskResult): StepNavigation?

    /**
     *  Return the step to go to before the given step.
     *
     *  @param step     The current step (or `null` if this is the first step).
     *  @param result   The current result set for this task.
     *  @return         A step navigation object defining the step, direction, and added results or `null` if either
     *                  this is the first step or reverse navigation is blocked.
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

    /**
     * Validates the task parameters.
     *
     * The implementation of this method should check that all the task parameters are correct. An invalid task is
     * considered an unrecoverable error: the implementation should throw an exception on parameter validation
     * failure.
     *
     * For example, an ordered task implementation would make sure that all its step identifiers are unique; throwing
     * an exception otherwise.
     *
     * This method is can be called by a task view model when its task is set.
     *
     *  @throws An error appropriate to the failed validation.
     */
    fun validate()
}