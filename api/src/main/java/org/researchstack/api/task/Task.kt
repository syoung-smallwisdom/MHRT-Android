package org.researchstack.api.task

import org.researchstack.api.Identifiable
import org.researchstack.api.navigation.StepNavigator
import org.researchstack.api.result.collection.TaskResult

/**
 *  `Task` is the interface for running a task. It includes information about how to calculate
 *  progress, validation, and the order of display for the steps.
 */
interface Task : Identifiable {

    /**
     *  The step navigator for this task.
     */
    val stepNavigator: StepNavigator

    /**
     *  Instantiate a task result that is appropriate for this task.
     * 
     *  - returns: A task result for this task.
     */
    fun instantiateTaskResult(): TaskResult

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