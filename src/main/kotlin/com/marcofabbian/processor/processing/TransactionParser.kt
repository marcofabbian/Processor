package com.marcofabbian.processor.processing

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.marcofabbian.processor.dto.*
import com.marcofabbian.processor.processing.dividend.XmlDividend
import com.marcofabbian.processor.processing.liquidation.XmlLiquidation
import com.marcofabbian.processor.processing.merger.XmlMerger
import org.springframework.stereotype.Component
import org.w3c.dom.Document
import java.io.StringWriter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

@Component
class TransactionParser(
) {
    fun parse(doc:Document): Transaction {
        return if(doc.isDividend()){
            mapToTransaction(mapDocumentToDto(doc, XmlDividend::class.java) as Object)
        } else if(doc.isLiquidation()) {
            mapToTransaction(mapDocumentToDto(doc, XmlLiquidation::class.java) as Object)
        } else if(doc.isMerger()) {
            mapToTransaction(mapDocumentToDto(doc, XmlMerger::class.java) as Object)
        } else
            throw Exception("Transaction not managed.")
    }
}

fun Document.isDividend():Boolean = this.getElementsByTagName("BkToCstmrDbtCdtNtfctn").length > 0
fun Document.isLiquidation():Boolean = this.getElementsByTagName("SctiesStmtGnl").length > 0
fun Document.isMerger():Boolean = this.getElementsByTagName("CorpActnNtfctn").length > 0

fun documentToString(document: Document): String {
    val transformer = TransformerFactory.newInstance().newTransformer()
    val writer = StringWriter()
    transformer.transform(DOMSource(document), StreamResult(writer))
    return writer.toString()
}

fun <T> mapDocumentToDto(document: Document, dtoClass: Class<T>): T {
    val xmlMapper = XmlMapper()
    val xmlString = documentToString(document)
    return xmlMapper.readValue(xmlString, dtoClass)
}

fun mapToTransaction(data:Object): Transaction {
    when(data.javaClass.simpleName) {
        XmlDividend::class.simpleName -> {
            val details = (data as XmlDividend).notification?.notificationDetails !!
            val header = (data as XmlDividend).notification?.groupHeader !!
            return Dividend(
                header.messageId !!,
                LocalDateTime.parse(header.creationDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")),
                BankAccount(details.entry?.entryDetails?.transactionDetails?.relatedParties?.creditorAccount?.id?.iban!!),
                BankAccount(details.entry?.entryDetails?.transactionDetails?.relatedParties?.debtorAccount?.id?.iban!!)
            )
        }
        XmlLiquidation::class.simpleName -> {
            val header = (data as XmlLiquidation).securitiesStatementGeneral !!
            val details = (data as XmlLiquidation).securitiesTransfer !!
            return Liquidation(
                header.statementId,
                LocalDateTime.parse(header.creationDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")),
                BankAccount(details.relatedParties?.debtorAccount?.accountId?.iban !!),
                BankAccount(details.relatedParties?.creditorAccount?.accountId?.iban !!)
            )
        }
        XmlMerger::class.simpleName -> {
            val details = (data as XmlMerger).corpActionNotification
            val creation = LocalDate.parse(details.eventDetails.date, DateTimeFormatter.ofPattern("yyyy-MM-dd")) !!
            return Merger(
                details.notificationId !!,
                LocalDateTime.of(creation, LocalTime.now()),
                BankAccount("IT60X0542811101000000123456"),
                BankAccount("IT60X0542811101000000123456")
            )
        }
        else -> throw Exception("Xml Structure not defined.")
    }
}
