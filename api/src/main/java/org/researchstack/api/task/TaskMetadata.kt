package org.researchstack.api.task

/**
 *  `TaskMetadata` includes information to display about a task before the task is fetched or loaded
 *  from an embedded resource. This can be used to display a collection of tasks and only load the
 *  task when selected by the participant or used with a `TaskMetadataStep` to combine sources for
 *  tasks that are presented as a single flow.
 */
interface TaskMetadata  {

    /**
     *  A short string that uniquely identifies the task.
     */
    val identifier: String

    /**
     *  The primary text to display for the task in a localized string.
     */
    val title: String?

    /**
     *  The subtitle text to display for the task in a localized string.
     */
    val subtitle: String?
}