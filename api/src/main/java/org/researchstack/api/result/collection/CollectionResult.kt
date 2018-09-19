package org.researchstack.api.result.collection

import org.researchstack.api.lastWith
import org.researchstack.api.removeAllWith
import org.researchstack.api.result.Result

/**
 *  `CollectionResult` is used to group multiple results associated with a single step or async
 *  action that may have more that one result.
 */
interface CollectionResult : Result {

    /**
     * The list of input results associated with this step.
     */
    val inputResults: MutableList<Result>
}

/**
 *  Find a result within the input results.
 *
 *  @param step      The step associated with the result.
 *  @return          The result or `nil` if not found.
 */
fun CollectionResult.findResult(identifier: String): Result? =
        this.inputResults.lastWith(identifier)

/**
 *  Append the result to the end of the input results, removing any previous instances with the
 *  same identifier if necessary.
 *
 *  @param result       The result to add to the step history.
 */
fun CollectionResult.appendInputResults(result: Result) {
    this.inputResults.removeAllWith(result.identifier)
    this.inputResults.add(result)
}

/**
 * Remove any results with the given identifier.
 *
 * @param identifier    The identifier of the result to remove.
 */
fun CollectionResult.removeInputResultWith(identifier: String) =
    this.inputResults.removeAllWith(identifier)

// TODO: syoung 09/18/2018 Convert to Swift if implementing the AnswerResultFinder interface.
//
//    /// Find an *answer* result within this collection. This method will return `nil` if there is a result
//    /// but that result does **not** conform to to the `RSDAnswerResult` protocol.
//    ///
//    /// - seealso: `RSDAnswerResultFinder`
//    ///
//    /// - parameter identifier: The identifier associated with the result.
//    /// - returns: The result or `nil` if not found.
//    public func findAnswerResult(with identifier:String ) -> RSDAnswerResult? {
//        return self.findResult(with: identifier) as? RSDAnswerResult
//    }
//
//    /// Return a mapping of all the `RSDAnswerResult` objects in this collection as a mapping
//    /// of the identifier to the value.
//    public func answers() -> [String : Any] {
//        return self.inputResults.reduce(into: [String : Any]()) { (hashtable, result) in
//        guard let answerResult = result as? RSDAnswerResult, let value = answerResult.value else { return }
//        hashtable[answerResult.identifier] = value
//    }
//    }