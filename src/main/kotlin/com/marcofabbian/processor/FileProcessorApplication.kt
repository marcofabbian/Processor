package com.marcofabbian.processor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FileProcessorApplication

fun main(args: Array<String>) {
	runApplication<FileProcessorApplication>(*args)
}
