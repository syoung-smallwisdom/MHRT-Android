package org.researchstack.task

import org.researchstack.api.task.TaskMetadata

data class TaskMetadata(
        override val identifier: String,
        override val title: String? = null,
        override val subtitle: String? = null) : TaskMetadata {
}