package com.marcofabbian.processor.flow

import com.marcofabbian.processor.input.FileMonitor
import org.springframework.stereotype.Component

@Component
class ProcessorFlow(
    private val monitor: FileMonitor,
) {

    fun flow() {
        monitor.run() {
            println("File $it")

        }
    }
}