package com.marcofabbian.processor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
	"com.marcofabbian.processor.*"
])
class FileProcessorApplication

fun main(args: Array<String>) {
	runApplication<FileProcessorApplication>(*args)
}