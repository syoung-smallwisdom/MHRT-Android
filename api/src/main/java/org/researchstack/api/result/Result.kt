package org.researchstack.api.result

import java.time.LocalDate

/**
 *  `Result` is the base implementation for a result associated with a task, step, or asynchronous
 *  action.
 * 
 *  When running a task, there will be a result of some variety used to mark each step in the task.
 *  This is the base interface.
 */
interface Result {

    /**
     *  The identifier associated with the task, step, or asynchronous action.
     */
    val identifier: String

    /**
     *  A String that indicates the type of the result. This can be used to serialize and
     *  deserialize the result using a factory.
     */
    var resultType: String

    /**
     *  The start date timestamp for the result.
     */
    var startDate: LocalDate

    /**
     *  The end date timestamp for the result.
     */
    var endDate: LocalDate
}