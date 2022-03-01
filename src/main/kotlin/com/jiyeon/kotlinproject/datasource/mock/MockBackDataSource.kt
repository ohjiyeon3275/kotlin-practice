package com.jiyeon.kotlinproject.datasource.mock

import com.jiyeon.kotlinproject.datasource.BankDataSource
import com.jiyeon.kotlinproject.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBackDataSource: BankDataSource {

    /**
     * mutable list
     */
    val banks = mutableListOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100))

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank {
        return banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find bank with accountNumber $accountNumber ")
    }

    override fun createBank(bank: Bank): Bank {

        /**
         * any 함수의 기능 :
         * Returns `true` if at least one element matches the given [predicate].
         */

        if ( banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("book with account number ${bank.accountNumber} already exists!")
        }

        banks.add(bank)
        return bank
    }
}