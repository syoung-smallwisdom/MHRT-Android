package org.researchstack.api.result.collection

import org.researchstack.api.lastWith
import org.researchstack.api.removeAllWith
import org.researchstack.api.result.Result
import org.researchstack.api.result.values.AnswerResult
import org.researchstack.api.result.values.AnswerResultFinder

/**
 *  `CollectionResult` is used to group multiple results associated with a single step or async
 *  action that may have more that one result.
 */
interface CollectionResult : Result, AnswerResultFinder {

    /**
     * The list of input results associated with this step.
     */
    val inputResults: MutableList<Result>

    /**
     *  Find a result within the input results.
     *
     *  @param step      The step associated with the result.
     *  @return          The result or `nil` if not found.
     */
    fun findResult(identifier: String): Result? =
            this.inputResults.lastWith(identifier)

    /**
     *  Append the result to the end of the input results, removing any previous instances with the
     *  same identifier if necessary.
     *
     *  @param result       The result to add to the step history.
     */
    fun appendInputResults(result: Result) {
        this.inputResults.removeAllWith(result.identifier)
        this.inputResults.add(result)
    }

    /**
     * Remove any results with the given identifier.
     *
     * @param identifier    The identifier of the result to remove.
     */
    fun removeInputResultWith(identifier: String) =
            this.inputResults.removeAllWith(identifier)

    /**
     *  Use the `findResult()` method to search for an `AnswerResult` that matches this identifier. This method is
     *  *not* recursive.
     */
    override fun findAnswerResult(identifier: String): AnswerResult? =
            this.findResult(identifier) as? AnswerResult

}

