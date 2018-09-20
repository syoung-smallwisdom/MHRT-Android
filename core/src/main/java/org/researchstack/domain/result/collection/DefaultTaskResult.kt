package org.researchstack.domain.result.collection

import org.researchstack.api.result.Result
import org.researchstack.api.result.collection.TaskResult
import org.threeten.bp.Instant
import java.util.UUID

data class DefaultTaskResult(
        override val identifier: String,
        override val resultType: String = "task"
) : TaskResult {

    override var startDate: Instant = Instant.now()
    override var endDate: Instant? = null

    override var taskRunUUID: UUID = UUID.randomUUID()
    override val stepHistory: MutableList<Result> = mutableListOf<Result>()
    override val asyncResults: MutableList<Result> = mutableListOf<Result>()
}