package org.researchstack.api.navigation

import org.researchstack.api.result.Result
import org.researchstack.api.step.Step

/**
 * The navigation is a tuple of the step, direction, and (if applicable) the new task result if the
 * navigator mutated the result while evaluating a request to navigate forward or back.
 *
 * @param step              The step to move to.
 *
 * @param direction         The direction of movement. Typically, the direction of navigation can be inferred from the
 *                          calling class, but occasionally, the user will be directed backward in the flow and the UX
 *                          should reflect that by using a "pop" animation rather than a "push" animation.
 *
 * @param asyncResults      Optional list of results to insert into the `TaskResult.asyncResults`.
 *                          Typically, navigation will be stateless, using only the current task result and current
 *                          step to determine the next step to move to, but in some cases, the navigator needs to
 *                          record calculated results that are displayed in future steps to the user.
 *
 * @param backgroundTask    Optional additional information about asynchronous actions that can run across step
 *                          boundaries.
 *
 * @see `StepNavigator`
 */
data class StepNavigation(
        val step: Step,
        val direction: Direction,
        val asyncResults: List<Result> = listOf<Result>(),
        val backgroundTask: BackgroundTask? = null
) {

    /**
     * The direction in which the UI/UX should show navigation. For example, in some cases, a result
     * could give a "looping" style of navigation where the participant is directed backward in the task
     * step order. In this case, the UX might call for a "pop" animation rather than a "push" animation.
     */
    enum class Direction {
        REVERSE, FORWARD, NONE
    }
}