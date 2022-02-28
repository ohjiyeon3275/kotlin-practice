package com.jiyeon.kotlinproject.datasource

import com.jiyeon.kotlinproject.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>

    fun retrieveBank(accountNumber: String) : Bank
}