package org.researchstack.api.result

import org.researchstack.api.Identifiable
import org.threeten.bp.Instant

/**
 *  `Result` is the base implementation for a result associated with a task, step, or asynchronous
 *  action.
 *
 *  When running a task, there will be a result of some variety used to mark each step in the task.
 *  This is the base interface.
 */
interface Result : Identifiable {

    /**
     *  A String that indicates the type of the result. This can be used to serialize and
     *  deserialize the result using a factory.
     */
    val resultType: String

    /**
     *  The start date timestamp for the result.
     */
    var startDate: Instant

    /**
     *  The end date timestamp for the result. If `null`, then the task is assumed to still be running.
     */
    var endDate: Instant?
}