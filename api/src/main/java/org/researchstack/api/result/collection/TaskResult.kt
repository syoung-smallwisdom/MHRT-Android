package org.researchstack.api.result.collection

import org.researchstack.api.lastWith
import org.researchstack.api.step.Step
import java.util.UUID
import org.researchstack.api.removeAllWith
import org.researchstack.api.result.Result
import org.researchstack.api.result.values.AnswerResult
import org.researchstack.api.result.values.AnswerResultFinder

/**
 *  `TaskResult` is a result associated with a task. This object includes a step history, task run
 *  UUID, and asynchronous results.
 */
interface TaskResult : Result, AnswerResultFinder {

    /**
     *  A unique identifier for this task run.
     */
    var taskRunUUID: UUID

    /**
     *  A listing of the step history for this task or section. The listed step results should
     *  *only* include the last result for any given step.
     */
    val stepHistory: MutableList<Result>

    /**
     *  A list of all the asynchronous results for this task. The list should include uniquely
     *  identified results. The step history is used to describe the path you took to get to where
     *  you are going, whereas the asynchronous results include any canonical results that are
     *  independent of path.
     */
    val asyncResults: MutableList<Result>

    /**
     *  Find a result within the step history.
     *
     *  @param step      The step associated with the result.
     *  @return          The result or `nil` if not found.
     */
    fun findResult(step: Step): Result? =
            this.stepHistory.lastWith(step.identifier)

    /**
     *  Append the result to the end of the step history, removing any previous instances with the
     *  same identifier if necessary.
     *
     *  @param result       The result to add to the step history.
     */
    fun appendStepHistory(result: Result) {
        this.stepHistory.removeAllWith(result.identifier)
        this.stepHistory.add(result)
    }

    /**
     *  Remove results from the step history from the result with the given identifier to the end of
     *  the array.
     *
     *  @param stepIdentifier   The identifier of the result associated with the given step.
     *  @return                 The previous results or `null` if there weren't any.
     */
    fun removeToEndOfStepHistoryFrom(stepIdentifier: String): List<Result> {
        val idx = this.stepHistory.indexOfFirst { r -> r.identifier == stepIdentifier }
        if (idx == -1) { return listOf<Result>() }

        val end = this.stepHistory.count()
        val subrange = this.stepHistory.slice(idx until end)
        val identifiers = subrange.map { r -> r.identifier }
        stepHistory.removeAll { r -> identifiers.contains(r.identifier) }

        return subrange
    }

    /**
     *  Append the result to the async results, removing any previous instances with the same
     *  identifier if necessary.
     *
     *  @param result       The result to add to the step history.
     */
    fun appendAsyncResults(result: Result) {
        this.asyncResults.removeAllWith(result.identifier)
        this.asyncResults.add(result)
    }

    /**
     * Search through the `stepHistory` for an `AnswerResultFinder` that returns a non-null `AnswerResult`. This
     * method is *not* recursive.
     */
    override fun findAnswerResult(identifier: String): AnswerResult? {
        val stepHistoryAnswer = this.stepHistory.mapNotNull { result ->
            if (result is AnswerResultFinder) result.findAnswerResult(identifier) else null
        }
        return stepHistoryAnswer.first()
    }
}

