package com.marcofabbian.processor.persistence

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BatchRepo : MongoRepository<BatchInfo, String>