package org.researchstack.api.task

import org.researchstack.api.Metadata

/**
 *  `TaskMetadata` includes information to display about a task before the task is fetched or loaded from an embedded
 *  resource. This can be used to display a collection of tasks and only load the task when selected by the
 *  participant or used with a `TaskMetadataStep` to combine sources for tasks that are presented as a single flow.
 *
 *  The use of this interface is *not* required, but is provided as a convenience for managing the issue of
 *  normalizing the interface for tasks that may come from different sources or modules.
 */
interface TaskMetadata : Metadata {
}