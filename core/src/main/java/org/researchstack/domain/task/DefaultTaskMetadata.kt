package org.researchstack.domain.task

import org.researchstack.api.task.TaskMetadata

data class DefaultTaskMetadata(
        override val identifier: String,
        override val title: String? = null,
        override val subtitle: String? = null,
        override val detail: String? = null,
        override val footnote: String? = null
) : TaskMetadata