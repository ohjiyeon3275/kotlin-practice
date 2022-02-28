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

}