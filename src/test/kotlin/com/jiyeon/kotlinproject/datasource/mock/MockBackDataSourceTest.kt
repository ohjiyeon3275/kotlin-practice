package com.jiyeon.kotlinproject.datasource.mock

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class MockBackDataSourceTest{

    private val mockDataSource = MockBackDataSource()

    @Test
    fun `should provide a collection of banks` () {
        //given == arrange

        //when == act
        val banks = mockDataSource.getBanks()

        //then == assert
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        // when
        val banks = mockDataSource.getBanks()

        // then
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).allMatch { it.trust != 0.0 }
        assertThat(banks).allMatch { it.transactionFee != 0 }
    }
}