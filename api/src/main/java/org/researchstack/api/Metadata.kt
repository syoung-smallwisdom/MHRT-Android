package org.researchstack.api

/**
 *  `Metadata` is used to define properties that are commonly defined for a task or step.
 */
interface Metadata : Identifiable {

    /**
     *  The primary text to display for the step or task in a localized string.
     */
    val title: String?

    /**
     *  Additional text to display for the step or task in a localized string.
     *
     *  The additional text is often displayed in a smaller font below `title`. If you need to display a
     *  long question, it can work well to keep the title short and put the additional content in the
     *  `subtitle` property.
     */
    val subtitle: String?

    /**
     *  Additional detailed explanation for the step or task.
     *
     *  The font size and display of this property will depend upon the device type.
     */
    val detail: String?

    /**
     *  Additional text to display for the step or task in a localized string at the bottom of the view or only upon
     *  request.
     *
     *  The footnote is intended to be displayed in a smaller font at the bottom of the screen. It is intended to be
     *  used in order to include disclaimer, copyright, etc. that is important to be able to display about the step
     *  or task but should not distract from the main purpose.
     */
    val footnote: String?
}