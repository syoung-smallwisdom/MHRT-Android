package org.researchstack.api.step

import org.researchstack.api.Identifiable
import  org.researchstack.api.result.Result

/**
 * `Step` is the base protocol for the steps that can compose a task for presentation using a controller appropriate
 * to the device and application. Each `Step` object represents one logical piece of data entry, information, or
 * activity in a larger task.
 *
 * Implementations included in this SDK include:
 * 1. `UIStep` is used to define a UI step for display, voice commands, or both.
 * 2. `SectionStep` is used to define a logical subgroup of steps.
 * 3. `SubtaskStep` and `TaskMetadataStep` are used to combine tasks into a single flow. For example,
 *     if the researcher wishes to ask for survey responses before an activity.
 *
 * A step can be a question, an active test, or a simple instruction. An `Step` is typically paired with a UI/UX
 * interface that controls the actions of the step.
 *
 * For a step, the identifier is a short string that uniquely identifies the step within the task. The identifier is
 * reproduced in the results of a step history. In some cases, it can be useful to link the step identifier to a
 * unique identifier in a database; in other cases, it can make sense to make the identifier human readable.
 *
 */
interface Step : Identifiable {

    /**
     * The type of the step. This is can be used to decode the step using a factory and to customize
     * the UI/UX.
     */
    val stepType: String

    /**
     *  Validate the step parameters.
     *
     * The implementation of this method should check that all the step parameters are correct. An invalid step is
     * considered an unrecoverable error: the implementation should throw an exception on parameter validation
     * failure.
     *
     * For example, a form step implementation would make sure that all its input field identifiers are unique;
     * throwing an exception otherwise.
     *
     * This method is can be called by a step view model when its step is set.
     *
     *  @throws An error if validation fails.
     */
    fun validate()
}