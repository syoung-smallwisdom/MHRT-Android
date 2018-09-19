package org.researchstack.api

interface Identifiable {

    /**
     *  The identifier associated with the task, step, or asynchronous action.
     */
    val identifier: String
}

/**
 * Mutates a list of identifiable objects by removing the ones with the given identifier.
 */
fun <T>MutableList<T>.removeAllWith(identifier: String) {
    var idx = this.indexOfLastWith(identifier)
    while (idx >= 0) {
        this.removeAt(idx)
        idx = this.indexOfLastWith(identifier)
    }
}

/**
 * Returns a copy of this list after removing all objects with the given identifier.
 */
fun <T>List<T>.removingAllWith(identifier: String): List<T> {
    val mutableList = this.toMutableList()
    mutableList.removeAllWith(identifier)
    return mutableList.toList()
}

/**
 * Returns the index of the last result with the given identifier.
 */
fun <T>List<T>.indexOfLastWith(identifier: String): Int =
        this.indexOfLast { r ->
            if (r is Identifiable) r.identifier == identifier
            else false
        }

/**
 * Returns the last result with the given identifier or `null` if not found.
 */
fun <T>List<T>.lastWith(identifier: String): T? =
        this.last { r ->
            if (r is Identifiable) r.identifier == identifier
            else false
        }
