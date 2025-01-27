package com.marcofabbian.processor.persistence

import com.marcofabbian.processor.dto.*
import org.springframework.stereotype.Service

@Service
class PersistenceService(
    private val batchRepo:BatchRepo,
    private val transactionRepo:TransactionRepo
) {
    fun saveBatch(batch:Batch){
        batchRepo.save(BatchInfo(batch.batchId, batch.processing, batch.transactionNumber))
    }

    fun saveTransaction(transaction: Transaction){
        transactionRepo.save(transaction)
    }
}