package org.researchstack.api.step.collection

import org.researchstack.api.step.Step
import org.researchstack.api.task.Task

/**
 * `SubtaskStep` is a step that contains a task reference. Typically, this would be a "hidden" step that can be used
 * to combine different task modules in a single UX flow.
 *
 * For example, this step could be used to describe a task flow that combines a standard survey with an active task
 * where each is defined within a different module.
 */
interface SubtaskStep : Step {

    /**
     * The task for this step.
     */
    val task: Task

    /**
     * The identifier for a subtask step is the task identifier.
     */
    override val identifier: String
        get() = ( this.task.identifier )

    /**
     * Validation of the step requires validation of the task.
     */
    override fun validate() =
            this.task.validate()
}

