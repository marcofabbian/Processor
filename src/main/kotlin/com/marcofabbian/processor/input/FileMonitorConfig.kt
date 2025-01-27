package com.marcofabbian.processor.input

import org.springframework.context.annotation.Configuration

@Configuration
data class FileMonitorConfig(
    val path:String = "./files/swift/",
    val inProgressPath:String = "./files/swift/",
    val interval:Long = 10000
)