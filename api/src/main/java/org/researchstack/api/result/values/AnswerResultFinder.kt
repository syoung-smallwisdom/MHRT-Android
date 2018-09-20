package org.researchstack.api.result.values

/**
 *  `AnswerResultFinder` is a convenience interface used to retrieve an answer result. It is used in survey
 *  navigation to find the result for a given input field.
 */
interface AnswerResultFinder {

    /**
     *  Find an *answer* result within this result. This method will return `null` if there is a result
     *  but that result does *not* conform to to the `AnswerResult` interface.
     * 
     *  @param identifier   The identifier associated with the result.
     *  @return             The result or `null` if not found.
     */
    fun findAnswerResult(identifier: String): AnswerResult?
}