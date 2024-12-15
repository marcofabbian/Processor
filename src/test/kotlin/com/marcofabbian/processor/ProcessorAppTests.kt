package com.marcofabbian.processor

import com.marcofabbian.processor.input.FileMonitorConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertTrue

@SpringBootTest
class ProcessorAppTests(
) {

	@Test
	fun contextLoads() {
		assertTrue(true)
	}

}
