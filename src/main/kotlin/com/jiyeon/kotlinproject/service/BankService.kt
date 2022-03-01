package com.jiyeon.kotlinproject.service

import com.jiyeon.kotlinproject.datasource.BankDataSource
import com.jiyeon.kotlinproject.model.Bank
import org.springframework.stereotype.Service

@Service // or @Component
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> {
        return dataSource.retrieveBanks()
    }

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String): Unit {
        dataSource.deleteBank(accountNumber)
    }

}