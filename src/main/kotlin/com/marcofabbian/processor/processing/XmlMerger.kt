package com.marcofabbian.processor.processing.merger

import com.fasterxml.jackson.dataformat.xml.annotation.*

@JacksonXmlRootElement(localName = "Document")
data class XmlMerger(
    @JacksonXmlProperty(localName = "CorpActnNtfctn")
    val corpActionNotification: CorpActionNotification
)
data class CorpActionNotification(
    @JacksonXmlProperty(localName = "NtfctnId")
    val notificationId: String,

    @JacksonXmlProperty(localName = "EvtTp")
    val eventType: EventType,

    @JacksonXmlProperty(localName = "EvtId")
    val eventId: String,

    @JacksonXmlProperty(localName = "EvtSts")
    val eventStatus: EventStatus,

    @JacksonXmlProperty(localName = "EvtDtls")
    val eventDetails: EventDetails,

    @JacksonXmlProperty(localName = "UndrlygScty")
    val underlyingSecurity: UnderlyingSecurity,

    @JacksonXmlProperty(localName = "NewEntty")
    val newEntity: NewEntity,

    @JacksonXmlProperty(localName = "RltdPties")
    val relatedParties: RelatedParties,

    @JacksonXmlProperty(localName = "CorpActnOptnDtls")
    val corporateActionOptionDetails: CorporateActionOptionDetails
)
data class EventType(
    @JacksonXmlProperty(localName = "Cd")
    val code: String
)
data class EventStatus(
    @JacksonXmlProperty(localName = "Cd")
    val code: String
)
data class EventDetails(
    @JacksonXmlProperty(localName = "Dt")
    val date: String
)
data class UnderlyingSecurity(
    @JacksonXmlProperty(localName = "ISIN")
    val isin: String,

    @JacksonXmlProperty(localName = "Desc")
    val description: String
)
data class NewEntity(
    @JacksonXmlProperty(localName = "Nm")
    val name: String,

    @JacksonXmlProperty(localName = "ISIN")
    val isin: String,

    @JacksonXmlProperty(localName = "Desc")
    val description: String
)
data class RelatedParties(
    @JacksonXmlProperty(localName = "Dbtr")
    val debtor: Debtor,

    @JacksonXmlProperty(localName = "DbtrAcct")
    val debtorAccount: Account,

    @JacksonXmlProperty(localName = "Cdtr")
    val creditor: Creditor,

    @JacksonXmlProperty(localName = "CdtrAcct")
    val creditorAccount: Account
)
data class Debtor(
    @JacksonXmlProperty(localName = "Nm")
    val name: String
)
data class Creditor(
    @JacksonXmlProperty(localName = "Nm")
    val name: String
)
data class Account(
    @JacksonXmlProperty(localName = "Id")
    val identifier: Identifier
)
data class Identifier(
    @JacksonXmlProperty(localName = "IBAN")
    val iban: String
)
data class CorporateActionOptionDetails(
    @JacksonXmlProperty(localName = "OptnId")
    val optionId: String,

    @JacksonXmlProperty(localName = "OptnTp")
    val optionType: OptionType,

    @JacksonXmlProperty(localName = "OptnDtls")
    val optionDetails: OptionDetails
)
data class OptionType(
    @JacksonXmlProperty(localName = "Cd")
    val code: String
)
data class OptionDetails(
    @JacksonXmlProperty(localName = "XchgRatio")
    val exchangeRatio: Double
)