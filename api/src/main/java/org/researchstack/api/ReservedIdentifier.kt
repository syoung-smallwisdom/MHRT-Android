package org.researchstack.api

/**
 * A list of the string identifiers that are reserved and have a special meaning.
 */
enum class ReservedIdentifier(val rawValue: String) {
    ERROR("error"),
    EXIT("exit"),
    NEXT_SECTION("nextSection"),
    NEXT_STEP("nextStep")
}