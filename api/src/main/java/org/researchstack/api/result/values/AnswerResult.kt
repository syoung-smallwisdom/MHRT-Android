package org.researchstack.api.result.values

import org.researchstack.api.result.Result
import java.io.Serializable

interface AnswerResult : Result, AnswerResultFinder {

    /**
     * The answer type of the answer result. This includes coding information required to serialize the value. The
     * value is expected to conform to one of the coding types supported by the answer type.
     * The answer for the result. If `null` then this marks an answer that was skipped by the participant.
     */
    val answerType: AnswerResultType

    /**
     * The answer for the result. If `null` then this marks an answer that was skipped by the participant.
     */
    val value: Any?

    /**
     * The converted value to store as the "answer" to a question. This should include any unit conversion, encoding
     * of a serializable object to a JSON object (string, number, boolean, array, or dictionary), etc. that is
     * required by the app to normalize the value.
     */
    fun answer(): Serializable?

    /**
     * For an answer result, it matches the identifier to its identifier.
     */
    override fun findAnswerResult(identifier: String): AnswerResult? =
        if (this.identifier == identifier) this else null

}

