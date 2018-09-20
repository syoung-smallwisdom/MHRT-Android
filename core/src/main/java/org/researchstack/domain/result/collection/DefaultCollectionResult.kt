package org.researchstack.domain.result.collection

import org.researchstack.api.result.Result
import org.researchstack.api.result.collection.CollectionResult
import org.threeten.bp.Instant

data class DefaultCollectionResult(
        override val identifier: String,
        override val resultType: String = "collection"
) : CollectionResult {

    override var startDate: Instant = Instant.now()
    override var endDate: Instant? = null

    override val inputResults: MutableList<Result> = mutableListOf<Result>()
}