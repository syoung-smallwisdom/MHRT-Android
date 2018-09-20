package org.researchstack.api.result.values

/**
 *  `AnswerResultType` is an enum  that can be used to describe how to serialize an `AnswerResult`. It carries
 *  information about the type of the value and how to encode it. This struct serves a different purpose from the
 *  `FormDataType` because it only carries information required to store a result and *not* additional information
 *  about presentation style.
 *
 *  @see `AnswerResult` and `FormDataType`
 *
 *
 *  @param baseType                 The base type for the answer.
 *
 *  @param sequenceSeparator        The sequence separator to use when storing a multiple component answer as a
 *                                  string or when choices should be included as a comma-delimited string.
 *                                  For example, blood pressure might be represented using an array with two fields
 *                                  but is stored as a single string value of "120/90". In this case, "/" would be
 *                                  the separator.
 *
 *  @param isArray                  Is the answer an array? Default value is `false` unless the `sequenceSeparator`
 *                                  is non-null.
 *
 */
data class AnswerResultType(
        val baseType: BaseType,
        val sequenceSeparator: String? = null,
        val isArray: Boolean = (sequenceSeparator != null)) {

    /**
     *  The base type of the answer result. This is used to indicate what the type is of the value being stored. The
     *  value stored in the `AnswerResult` should be convertable to one of these base types.
     */
    enum class BaseType(val rawValue: String) {
        BOOLEAN("boolean"),
        DATA("data"),                   // A binary data blob.
        DATE("date"),                   // A date value. This can be a date only, time only, timestamp, etc.
        DECIMAL("decimal"),
        INTEGER("integer"),
        SERIALIZABLE("serializable"),   // An object that can be serialized as JSON.
        STRING("string")
    }

    private object Holder {
        val BOOLEAN = AnswerResultType(BaseType.BOOLEAN)
        val INTEGER = AnswerResultType(BaseType.INTEGER)
        val STRING = AnswerResultType(BaseType.STRING)
        val DECIMAL = AnswerResultType(BaseType.DECIMAL)
        val DATE = AnswerResultType(BaseType.DATE)
        val INTEGER_ARRAY = AnswerResultType(BaseType.INTEGER, isArray = true)
        val STRING_ARRAY = AnswerResultType(BaseType.STRING, isArray = true)
        val DECIMAL_ARRAY = AnswerResultType(BaseType.DECIMAL, isArray = true)
    }

    companion object {
        val BOOLEAN: AnswerResultType by lazy { Holder.BOOLEAN }
        val INTEGER: AnswerResultType by lazy { Holder.INTEGER }
        val STRING: AnswerResultType by lazy { Holder.STRING }
        val DECIMAL: AnswerResultType by lazy { Holder.DECIMAL }
        val DATE: AnswerResultType by lazy { Holder.DATE }
        val INTEGER_ARRAY: AnswerResultType by lazy { Holder.INTEGER_ARRAY }
        val STRING_ARRAY: AnswerResultType by lazy { Holder.STRING_ARRAY }
        val DECIMAL_ARRAY: AnswerResultType by lazy { Holder.DECIMAL_ARRAY }
    }
}