package com.marcofabbian.processor.persistence

import com.marcofabbian.processor.dto.Transaction
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepo : MongoRepository<Transaction, String>