package com.marcofabbian.processor.processing.dividend

import com.fasterxml.jackson.dataformat.xml.annotation.*

data class XmlDividend(
    @JacksonXmlProperty(localName = "BkToCstmrDbtCdtNtfctn")
    val notification: Notification? = null
)
data class Notification(
    @JacksonXmlProperty(localName = "GrpHdr")
    val groupHeader: GroupHeader? = null,

    @JacksonXmlProperty(localName = "Ntfctn")
    val notificationDetails: NotificationDetails? = null
)
data class GroupHeader(
    @JacksonXmlProperty(localName = "MsgId")
    val messageId: String? = null,

    @JacksonXmlProperty(localName = "CreDtTm")
    val creationDateTime: String? = null,

    @JacksonXmlProperty(localName = "NbOfTxs")
    val numberOfTransactions: Int? = null,

    @JacksonXmlProperty(localName = "CtrlSum")
    val controlSum: Double? = null,

    @JacksonXmlProperty(localName = "InitgPty")
    val initiatingParty: InitiatingParty? = null
)
data class InitiatingParty(
    @JacksonXmlProperty(localName = "Nm")
    val name: String? = null,

    @JacksonXmlProperty(localName = "Id")
    val id: PartyId? = null
)
data class PartyId(
    @JacksonXmlProperty(localName = "OrgId")
    val orgId: OrganizationId? = null
)
data class OrganizationId(
    @JacksonXmlProperty(localName = "Othr")
    val other: OtherId? = null
)
data class OtherId(
    @JacksonXmlProperty(localName = "Id")
    val id: String? = null
)
data class NotificationDetails(
    @JacksonXmlProperty(localName = "Id")
    val id: String? = null,

    @JacksonXmlProperty(localName = "NtfctnPgntn")
    val pagination: Pagination? = null,

    @JacksonXmlProperty(localName = "Acct")
    val account: Account? = null,

    @JacksonXmlProperty(localName = "Ntry")
    val entry: Entry? = null
)
data class Pagination(
    @JacksonXmlProperty(localName = "PgNb")
    val pageNumber: Int? = null,

    @JacksonXmlProperty(localName = "LastPgInd")
    val lastPageIndicator: Boolean? = null
)
data class Account(
    @JacksonXmlProperty(localName = "Id")
    val id: AccountId? = null,

    @JacksonXmlProperty(localName = "Ccy")
    val currency: String? = null
)
data class AccountId(
    @JacksonXmlProperty(localName = "IBAN")
    val iban: String? = null
)
data class Entry(
    @JacksonXmlProperty(localName = "Amt")
    val amount: Amount? = null,

    @JacksonXmlProperty(localName = "CdtDbtInd")
    val creditDebitIndicator: String? = null,

    @JacksonXmlProperty(localName = "Sts")
    val status: Status? = null,

    @JacksonXmlProperty(localName = "BookgDt")
    val bookingDate: DateElement? = null,

    @JacksonXmlProperty(localName = "ValDt")
    val valueDate: DateElement? = null,

    @JacksonXmlProperty(localName = "BkTxCd")
    val bankTransactionCode: BankTransactionCode? = null,

    @JacksonXmlProperty(localName = "NtryDtls")
    val entryDetails: EntryDetails? = null
)
data class Amount(
    @JacksonXmlProperty(isAttribute = true, localName = "Ccy")
    val currency: String? = null,

    @JacksonXmlProperty(localName = "")
    val value: Double? = null
)
data class Status(
    @JacksonXmlProperty(localName = "Cd")
    val code: String? = null
)
data class DateElement(
    @JacksonXmlProperty(localName = "Dt")
    val date: String? = null
)
data class BankTransactionCode(
    @JacksonXmlProperty(localName = "Prtry")
    val proprietary: ProprietaryCode? = null
)
data class ProprietaryCode(
    @JacksonXmlProperty(localName = "Cd")
    val code: String? = null,

    @JacksonXmlProperty(localName = "Issr")
    val issuer: String? = null
)
data class EntryDetails(
    @JacksonXmlProperty(localName = "TxDtls")
    val transactionDetails: TransactionDetails? = null
)
data class TransactionDetails(
    @JacksonXmlProperty(localName = "Refs")
    val references: References? = null,

    @JacksonXmlProperty(localName = "Amt")
    val amount: Amount? = null,

    @JacksonXmlProperty(localName = "CdtDbtInd")
    val creditDebitIndicator: String? = null,

    @JacksonXmlProperty(localName = "RltdPties")
    val relatedParties: RelatedParties? = null,

    @JacksonXmlProperty(localName = "RltdAgts")
    val relatedAgents: RelatedAgents? = null,

    @JacksonXmlProperty(localName = "AddtlTxInf")
    val additionalTransactionInfo: String? = null
)
data class References(
    @JacksonXmlProperty(localName = "EndToEndId")
    val endToEndId: String? = null,

    @JacksonXmlProperty(localName = "InstrId")
    val instructionId: String? = null,

    @JacksonXmlProperty(localName = "TxId")
    val transactionId: String? = null
)
data class RelatedParties(
    @JacksonXmlProperty(localName = "Dbtr")
    val debtor: Party? = null,

    @JacksonXmlProperty(localName = "DbtrAcct")
    val debtorAccount: Account? = null,

    @JacksonXmlProperty(localName = "Cdtr")
    val creditor: Party? = null,

    @JacksonXmlProperty(localName = "CdtrAcct")
    val creditorAccount: Account? = null
)
data class Party(
    @JacksonXmlProperty(localName = "Nm")
    val name: String? = null
)
data class RelatedAgents(
    @JacksonXmlProperty(localName = "DbtrAgt")
    val debtorAgent: FinancialInstitution? = null,

    @JacksonXmlProperty(localName = "CdtrAgt")
    val creditorAgent: FinancialInstitution? = null
)
data class FinancialInstitution(
    @JacksonXmlProperty(localName = "FinInstnId")
    val financialInstitutionId: FinancialInstitutionId? = null
)
data class FinancialInstitutionId(
    @JacksonXmlProperty(localName = "BICFI")
    val bicfi: String? = null
)