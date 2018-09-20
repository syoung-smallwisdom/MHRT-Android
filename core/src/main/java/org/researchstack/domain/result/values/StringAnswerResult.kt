package org.researchstack.domain.result.values

import org.researchstack.api.result.values.AnswerResult
import org.researchstack.api.result.values.AnswerResultType
import org.threeten.bp.Instant
import java.io.Serializable

data class StringAnswerResult(
        override val identifier: String,
        val stringValue: String?,
        override val resultType: String = "answer"
) : AnswerResult {

    override var startDate: Instant = Instant.now()
    override var endDate: Instant? = null

    override val answerType: AnswerResultType
        get() = AnswerResultType.STRING

    override val value: Any?
        get() = stringValue

    override fun answer(): Serializable? = this.stringValue
}