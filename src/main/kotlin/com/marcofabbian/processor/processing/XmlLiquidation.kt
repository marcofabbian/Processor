package com.marcofabbian.processor.processing.liquidation

import com.fasterxml.jackson.dataformat.xml.annotation.*

@JacksonXmlRootElement(localName = "Document")
data class XmlLiquidation(
    @JacksonXmlProperty(localName = "SctiesStmtGnl")
    val securitiesStatementGeneral: SecuritiesStatementGeneral,

    @JacksonXmlProperty(localName = "SctiesTrf")
    val securitiesTransfer: SecuritiesTransfer
)

data class SecuritiesStatementGeneral(
    @JacksonXmlProperty(localName = "StmtId")
    val statementId: String,

    @JacksonXmlProperty(localName = "CreDtTm")
    val creationDateTime: String
)

data class SecuritiesTransfer(
    @JacksonXmlProperty(localName = "SttlmId")
    val settlementId: String,

    @JacksonXmlProperty(localName = "TradDt")
    val tradeDate: String,

    @JacksonXmlProperty(localName = "SttlmDt")
    val settlementDate: String,

    @JacksonXmlProperty(localName = "TradgPty")
    val tradingParty: Party,

    @JacksonXmlProperty(localName = "CtrPty")
    val counterParty: Party,

    @JacksonXmlProperty(localName = "FinInstrm")
    val financialInstrument: FinancialInstrument,

    @JacksonXmlProperty(localName = "RltdPties")
    val relatedParties: RelatedParties,

    @JacksonXmlProperty(localName = "TxDtls")
    val transactionDetails: TransactionDetails
)

data class Party(
    @JacksonXmlProperty(localName = "PtyId")
    val partyId: PartyId
)

data class PartyId(
    @JacksonXmlProperty(localName = "Id")
    val id: String,

    @JacksonXmlProperty(localName = "Nm")
    val name: String
)

data class FinancialInstrument(
    @JacksonXmlProperty(localName = "ISIN")
    val isin: String,

    @JacksonXmlProperty(localName = "Nm")
    val name: String,

    @JacksonXmlProperty(localName = "Qty")
    val quantity: Int
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
    val accountId: AccountId
)

data class AccountId(
    @JacksonXmlProperty(localName = "IBAN")
    val iban: String
)

data class TransactionDetails(
    @JacksonXmlProperty(localName = "SttlmMtd")
    val settlementMethod: String,

    @JacksonXmlProperty(localName = "TrfSts")
    val transferStatus: String,

    @JacksonXmlProperty(localName = "Pmt")
    val payment: Payment
)

data class Payment(
    @JacksonXmlProperty(localName = "Amt")
    val amount: Double,

    @JacksonXmlProperty(localName = "Ccy")
    val currency: String
)