package org.researchstack.api.result.collection

import org.researchstack.api.result.Result
import org.researchstack.api.step.Step
import java.util.UUID

/**
 *  `TaskResult` is a result associated with a task. This object includes a step history, task run
 *  UUID, and asynchronous results.
 */
interface TaskResult : Result {

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
}

/**
 *  Find a result within the step history.
 *
 *  @param step      The step associated with the result.
 *  @return          The result or `nil` if not found.
 */
fun TaskResult.findResult(step: Step): Result? =
        this.stepHistory.first { r -> r.identifier == step.identifier }

/**
 *  Append the result to the end of the step history, removing any previous instances with the
 *  same identifier if necessary.
 *
 *  @param result       The result to add to the step history.
 */
fun TaskResult.appendStepHistory(result: Result) {
    this.stepHistory.removeIf { r -> r.identifier == result.identifier }
    this.stepHistory.add(result)
}

/**
 *  Remove results from the step history from the result with the given identifier to the end of
 *  the array.
 *
 *  @param stepIdentifier   The identifier of the result associated with the given step.
 *  @return                 The previous results or `null` if there weren't any.
 */
fun TaskResult.removeToEndOfStepHistoryFrom(stepIdentifier: String): List<Result> {
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
fun TaskResult.appendAsyncResults(result: Result) {
    this.asyncResults.removeIf { r -> r.identifier == result.identifier }
    this.asyncResults.add(result)
}

// TODO: syoung 09/18/2018 Convert to Swift if implementing the AnswerResultFinder interface.
//
//     *  Find an *answer* result within this collection. This method will return `nil` if there is a result
//     *  but that result does **not** conform to to the `RSDAnswerResult` protocol.
//     *
//     *  - seealso: `RSDAnswerResultFinder`
//     *
//     *  - parameter identifier: The identifier associated with the result.
//     *  - returns: The result or `nil` if not found.
//    public func findAnswerResult(with identifier:String ) -> RSDAnswerResult? {
//        for result in stepHistory {
//            if let answerResult = (result as? RSDAnswerResultFinder)?.findAnswerResult(with: identifier) {
//                return answerResult
//            }
//        }
//        return nil
//    }
