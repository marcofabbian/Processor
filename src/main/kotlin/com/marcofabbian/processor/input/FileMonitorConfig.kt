package com.marcofabbian.processor.input

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
//@ConfigurationProperties(prefix = "file.monitor")
data class FileMonitorConfig(
    val path:String = "./files/swift/",
    val inProgressPath:String = "./files/swift/",
    val interval:Long = 10000
)