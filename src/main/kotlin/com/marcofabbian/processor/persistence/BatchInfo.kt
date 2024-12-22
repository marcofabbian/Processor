package com.marcofabbian.processor.persistence

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable()
data class BatchInfo(
    @SerialName("batchId")
    var batchId:String,
    @SerialName("processing")
    var processing: LocalDateTime,
    @SerialName("transactionNumber")
    var transactionNumber:Int
)