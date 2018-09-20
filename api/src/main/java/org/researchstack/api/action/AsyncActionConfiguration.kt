package org.researchstack.api.action

import org.researchstack.api.Identifiable

/**
 *  `AsyncActionConfiguration` defines general configuration for an asynchronous background action that should be run
 *  in the background. Depending upon the parameters and how the action is set up, this could be something that is
 *  run continuously or else is paused or reset based on a timeout interval.
 * 
 *  The configuration is intended to be a serializable object and does not call services, record data, or anything
 *  else. It does include a step identifier that can be used to let the `TaskViewModel` know when to trigger the
 *  async action.
 *
 *  If the device suports starting the action asynchronously, then the `identifier` maps to a result stored in
 *  `TaskResult.asyncResults`.
 * 
 *  @see `StepNavigation`
 */
interface AsyncActionConfiguration: Identifiable {

    /**
     * An identifier marking the step to start the action. If `null`, then the action should be started when the task
     * is started.
     */
    val startStepIdentifier: String?
}