package org.researchstack.api.navigation

import org.researchstack.api.action.AsyncActionConfiguration

/**
 * `BackgroundTask` is a tuple of the async actions to start and stop. The task ViewModel or Fragment is responsible
 * for controlling the UI/UX of managing required permissions as well as starting and stopping the actions if they
 * are appropriate for the given device.
 *
 * @param startActions  A list of the async actions that should be *started* while transitioning to this step.
 * @param stopActions  A list of the async actions that should be *stopped* while transitioning to this step.
 *
 * @see `StepNavigation`
 */
data class BackgroundTask(
        var startActions: List<AsyncActionConfiguration> = listOf<AsyncActionConfiguration>(),
        var stopActions: List<AsyncActionConfiguration> = listOf<AsyncActionConfiguration>()
)