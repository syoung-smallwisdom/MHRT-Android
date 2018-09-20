package org.researchstack.api.step.userinterface

import org.researchstack.api.step.Step
import org.researchstack.api.Metadata

/**
 *  `UIStep` is used to define a single "display unit". Depending upon the available real-estate, more than one
 *  `UIStep` may be displayed at a time. For example, on an tablet, you may choose to group a set of questions using
 *  a `SectionStep` whereas on a phone, you may choose to show each question sequentially on a separate screen.
 */
interface UIStep : Step, Metadata {
}