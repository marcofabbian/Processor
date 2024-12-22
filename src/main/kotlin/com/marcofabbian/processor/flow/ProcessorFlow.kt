package com.marcofabbian.processor.flow

import com.marcofabbian.processor.dto.Batch
import com.marcofabbian.processor.input.FileMonitor
import com.marcofabbian.processor.persistence.PersistenceService
import com.marcofabbian.processor.processing.TransactionParser
import org.springframework.stereotype.Component
import org.slf4j.*

@Component
class ProcessorFlow(
    private val monitor: FileMonitor,
    private val parser:TransactionParser,
    private val persistence: PersistenceService,
    private val logger: Logger = LoggerFactory.getLogger(ProcessorFlow::class.java)
) {

    init {
        monitor.run() { file ->
            logger.info("File ${file.name}")
            val batch = Batch(file)
            logger.info("BatchId : ${batch.batchId}")
            logger.info("Transactions  : ${batch.xmlDocuments.count()}")

            batch.xmlDocuments.forEach { doc ->
                val transaction = parser.parse(doc).apply {
                    batchId = batch.batchId
                }
                logger.info("Transaction : ${transaction.messageId}")
            }

            persistence.saveBatch(batch)
        }
    }
}