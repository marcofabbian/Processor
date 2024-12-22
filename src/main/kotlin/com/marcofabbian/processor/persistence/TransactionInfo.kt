package com.marcofabbian.processor.persistence

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
data class TransactionInfo(
    @SerialName("batchId")
    var batchId:String,

    
) {
}