package com.marcofabbian.processor.dto

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import org.w3c.dom.Document
import java.math.BigInteger
import java.security.MessageDigest
import java.time.LocalDateTime
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import kotlinx.serialization.*

@Serializable
data class Batch(
    private val payload: File
) {

    @SerialName("batchId")
    lateinit var batchId:String
        private set

    @SerialName("processing")
    lateinit var processing: LocalDateTime
        private set
    lateinit var xmlDocuments:List<Document>
        private set
    @SerialName("transactionNumber")
    var transactionNumber:Int = -1
        private set

    init {
        batchId = generateModularUID(payload.readText())

        processing = LocalDateTime.now()

        var transaction = ""
        val builder = DocumentBuilderFactory
            .newInstance()
            .newDocumentBuilder()
        var list = mutableListOf<Document>()

        BufferedReader(FileReader(payload)).use { reader ->
            reader.lineSequence().forEach { line ->
                if(line.equals("</document>",true )) {
                    transaction += line
                    val xml = builder.parse(InputSource(StringReader(transaction)))
                    list.add(xml)
                    transaction = ""
                } else {
                    transaction += line
                }
            }
        }
        xmlDocuments = list

        transactionNumber = list.count()
    }

    private fun generateModularUID(input: String): String {
        val hash = MessageDigest.getInstance("SHA-1").digest(input.toByteArray())
        val bigInt = BigInteger(1, hash)
        val modValue = bigInt.mod(BigInteger("9999999999999999")).toString()
        return modValue.padStart(16, '0') // Pad with leading zeros
    }
}