package org.researchstack.api.task

import org.researchstack.api.navigation.StepNavigator
import org.researchstack.api.result.collection.TaskResult

/// `Task` is the interface for running a task. It includes information about how to calculate
/// progress, validation, and the order of display for the steps.
interface Task {

    /// A short string that uniquely identifies the task.
    val identifier: String

    /// The step navigator for this task.
    val stepNavigator: StepNavigator

    /// Instantiate a task result that is appropriate for this task.
    ///
    /// - returns: A task result for this task.
    fun instantiateTaskResult(): TaskResult

    /// Validate the task to check for any model configuration that should throw an error.
    /// - throws: An error appropriate to the failed validation.
    fun validate()
}