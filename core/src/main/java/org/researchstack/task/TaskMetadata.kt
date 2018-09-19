package org.researchstack.task

import org.researchstack.api.task.TaskMetadata

class TaskMetadata : TaskMetadata {
    override val identifier: String

    override var title: String? = null

    override var subtitle: String? = null

    constructor(identifier: String) {
        this.identifier = identifier
    }
}