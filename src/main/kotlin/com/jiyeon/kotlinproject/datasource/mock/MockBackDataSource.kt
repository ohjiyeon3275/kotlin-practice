package com.jiyeon.kotlinproject.datasource.mock

import com.jiyeon.kotlinproject.datasource.BankDataSource
import com.jiyeon.kotlinproject.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBackDataSource: BankDataSource {

    val banks = listOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100))

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank {
        return banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find bank with accountNumber $accountNumber ")
    }
}