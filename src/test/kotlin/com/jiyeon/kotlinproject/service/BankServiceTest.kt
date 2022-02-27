package com.jiyeon.kotlinproject.service

import com.jiyeon.kotlinproject.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed = true)
    //when using mockk, you should specify its behavior to where method called -> given part

    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks` () {
        //given
//        every { dataSource.retrieveBanks() } returns emptyList() --> can be replaced relaxed part

        //when
        val banks = bankService.getBanks()

        //then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}