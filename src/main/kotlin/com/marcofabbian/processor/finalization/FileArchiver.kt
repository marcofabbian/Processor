package com.marcofabbian.processor.finalization

import org.springframework.stereotype.Component
import java.io.File

@Component
class FileArchiver(
    config:FileArchiverConfig
) {
    fun archive(file: File) {

    }
}