package com.marcofabbian.processor.dto
import java.time.LocalDateTime

class BankAccount(
    val iban:String
) {
    var countryCode:String
        private set
    var checkDigits:String
        private set
    var bankIdentifier:String
        private set
    var branchCode:String
        private set
    var accountNumber:String
        private set

    init {
        countryCode = iban.substring(0,2)
        checkDigits = iban.substring(2,4)
        bankIdentifier = iban.substring(4,8)
        branchCode = iban.substring(8,14)
        accountNumber = iban.substring(14,22)
    }
}
abstract class Transaction(
    val messageId:String,
    val creation:LocalDateTime,
    val creditAccount:BankAccount,
    val debitAccount:BankAccount,
)
class Dividend(
    messageId:String,
    creation:LocalDateTime,
    creditAccount:BankAccount,
    debitAccount:BankAccount,
) : Transaction(messageId,creation, creditAccount, debitAccount)
class Merger(
    messageId:String,
    creation:LocalDateTime,
    creditAccount:BankAccount,
    debitAccount:BankAccount,
) : Transaction(messageId,creation, creditAccount, debitAccount)
class Liquidation(
    messageId:String,
    creation:LocalDateTime,
    creditAccount:BankAccount,
    debitAccount:BankAccount,
) : Transaction(messageId,creation, creditAccount, debitAccount)