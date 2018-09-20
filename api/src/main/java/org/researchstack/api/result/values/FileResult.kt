package org.researchstack.api.result.values

import org.researchstack.api.result.Result
import java.io.File

interface FileResult : Result {

    /**
     *  The File location with the full path to the file-based result. This should *not* be encoded in the file 
     *  result if the results are encoded and uploaded  to a server. This is included for use in local file system 
     *  management **only**.
     * 
     *  @note It is the responsibility of the developer to ensure that the participant's private data is managed 
     *  securely.
     */
    val file: File

    /**
     * The MIME content type of the result.
     *
     * @example `"application/json"`
     */
    val contentType: String?

    /**
     * The system clock uptime when a recorder was started (if applicable).
     */
    val startUptime: Double?
}