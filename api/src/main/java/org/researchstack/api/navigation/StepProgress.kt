package org.researchstack.api.navigation

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
data class StepProgress(
        val current: Int,
        val total: Int,
        val isEstimated: Boolean
)