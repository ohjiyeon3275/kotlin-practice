package com.jiyeon.kotlinproject.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest{

    //this is only for Test.
    @Autowired
    lateinit var mockMvc: MockMvc

    @Nested
    @DisplayName("getBanks()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class getBanks {
        @Test
        fun `should return all banks`() {
            //when
            mockMvc.get("/api/banks")
                .andDo{ print() }

                //then
                .andExpect {
                    status { isOk() }
                } // lambda
        }
    }

    @Nested
    @DisplayName("getBank()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBank {

        @Test
        fun `should return the bank with the given account number`(){
            //given

            val accountNumber = 1234

            //when/then
            mockMvc.get("/api/banks/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status{ isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") { value("3.14") }
                    jsonPath("$.transactionFee") { value("17") }

                }
        }

    }


    /**
     * test run할때 using
     * gradle?
     * intelij?
     * build.execution.deployment -> build tools -> gradle
     *
     * @Nested
     *  계층구조의 테스트를 가능하게 해줌
     *  그냥 @Test로 한것보다 한번 더 감싸주었다.
     *
     */
}