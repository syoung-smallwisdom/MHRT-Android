package org.researchstack.api.step.collection

import org.researchstack.api.step.Step

/**
 *  `SectionStep` is used to define a logical subgrouping of steps such as a section in a longer 
 *  survey or an active step that includes an instruction step, countdown step, and activity step.
 */
interface SectionStep: Step {

    /**
     *  A list of the steps used to define this subgrouping of steps.
     */
    val steps: List<Step>
}