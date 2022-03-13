package com.jiyeon.kotlinproject.datasource.network.dto

import com.jiyeon.kotlinproject.model.Bank

data class BankList(
    val results: Collection<Bank>
)