package com.marcofabbian.processor.finalization

import org.springframework.context.annotation.Configuration

@Configuration
data class FileArchiverConfig(
    val inProgressPath:String = "./files/swift/",
    val archivedPath:String = "./files/swift/",
) {
}