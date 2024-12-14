package com.marcofabbian.processor.input

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "file.monitor")
data class FileMonitorConfig(
    val sourcePath:String,
    //val inProgressPath:String,
    //val interval:Long
)