package org.researchstack.api.step.collection

import org.researchstack.api.step.Step
import org.researchstack.api.task.TaskMetadata

/**
 * `TaskMetadataStep` is a step that contains a task metadata reference. This type of a reference
 * requires a factory or repository that can be queried by the task controller to fetch the
 * appropriate subtask for this step.
 */
interface TaskMetadataStep : Step {

    /**
     * The task metadata for this step.
     */
    val taskMetadata: TaskMetadata
}