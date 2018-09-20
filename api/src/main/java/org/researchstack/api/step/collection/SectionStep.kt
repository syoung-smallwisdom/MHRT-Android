package org.researchstack.api.step.collection

import org.researchstack.api.step.Step
import org.researchstack.api.step.userinterface.UIStep

/**
 *  `SectionStep` is used to define a logical grouping of steps such as a section in a longer survey or an active
 *  step that includes an instruction step, countdown step, and activity step.
 */
interface SectionStep: UIStep {

    /**
     *  A list of the steps used to define this grouping of steps.
     */
    val steps: List<UIStep>
}