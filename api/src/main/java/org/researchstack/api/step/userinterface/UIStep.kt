package org.researchstack.api.step.userinterface

import org.researchstack.api.step.Step

/**
 *  `UIStep` is used to define a single "display unit". Depending upon the available real-estate, 
 *  more than one `UIStep` may be displayed at a time. For example, on an tablet, you may choose to 
 *  group a set of questions using a `SectionStep`.
 */
interface UIStep: Step {

    /**
     *  The primary text to display for the step in a localized string.
     */
    val title: String?

    /**
     *  Additional text to display for the step in a localized string.
     * 
     *  The additional text is often displayed in a smaller font below `title`. If you need to display a
     *  long question, it can work well to keep the title short and put the additional content in the
     *  `text` property.
     */
    val text: String?

    /**
     *  Additional detailed explanation for the step.
     * 
     *  The font size and display of this property will depend upon the device type.
     */
    val detail: String?

    /**
     *  Additional text to display for the step in a localized string at the bottom of the view.
     * 
     *  The footnote is intended to be displayed in a smaller font at the bottom of the screen. It is
     *  intended to be used in order to include disclaimer, copyright, etc. that is important to display in
     *  the step but should not distract from the main purpose of the step.
     */
    val footnote: String?
}