package org.researchstack.api.result.values

import org.researchstack.api.result.Result

/**
 * `ErrorResult` is a result that holds information about an error. It allows for storing an error in task operation
 * to the result set.
 */
interface ErrorResult : Result {

    /**
     * The error that was thrown.
     */
    val error: Error

}