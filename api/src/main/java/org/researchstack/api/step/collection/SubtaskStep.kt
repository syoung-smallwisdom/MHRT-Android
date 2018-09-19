package org.researchstack.api.step.collection

import org.researchstack.api.result.Result
import org.researchstack.api.step.Step
import org.researchstack.api.task.Task

/**
 * `SubtaskStep` is a step that contains a task reference.
 */
interface SubtaskStep : Step {

    /**
     * The task for this step.
     */
    val task: Task
}

/**
 * A subtask step should always return the task identifier as its identifier.
 */
val SubtaskStep.identifier: String
    get() {
        return this.task.identifier
    }

/**
 * The step result for a subtask step should be the task result instantiated by the task.
 */
fun SubtaskStep.instantiateStepResult(): Result =
        this.task.instantiateTaskResult()

/**
 * Validation of the step requires validation of the task.
 */
fun SubtaskStep.validate() =
        this.task.validate()