package com.marcofabbian.processor.flow

import com.marcofabbian.processor.dto.Batch
import com.marcofabbian.processor.input.FileMonitor
import com.marcofabbian.processor.processing.TransactionParser
import org.springframework.stereotype.Component
import org.slf4j.*
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean

@Component
class ProcessorFlow(
    private val monitor: FileMonitor,
    private val parser:TransactionParser,
    private val logger: Logger = LoggerFactory.getLogger(ProcessorFlow::class.java)
) {

    init {
        monitor.run() { file ->
            logger.info("File ${file.name}")
            val batch = Batch(file)
            logger.info("BatchId : ${batch.batchId}")
            logger.info("Transactions  : ${batch.transactions.count()}")

            batch.transactions.forEach {doc ->
                val transaction = parser.parse(doc)
                logger.info("Transaction : ${transaction.messageId}")
                
            }
        }
    }

}