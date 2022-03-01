package com.jiyeon.kotlinproject.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.jiyeon.kotlinproject.model.Bank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
){


    val baseUrl = "/api/banks"

    @Nested
    @DisplayName("get /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBanks {
        @Test
        fun `should return all banks`() {
            //when
            mockMvc.get("$baseUrl")
                .andDo{ print() }

                //then
                .andExpect {
                    status { isOk() }
                } // lambda
        }
    }

    @Nested
    @DisplayName("get /api/bank/{accountNumber}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBank {

        @Test
        fun `should return the bank with the given account number`(){
            //given

            val accountNumber = 1234

            //when/then
            mockMvc.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status{ isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") { value("3.14") }
                    jsonPath("$.transactionFee") { value("17") }

                }
        }

    }

    @Test
    fun `should return NFE if the account number does not exist` () {
        //given
        val accountNumber = "does_not_exist"

        //when
        mockMvc.get("$baseUrl/$accountNumber")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
        //then
    }

    @Nested
    @DisplayName("post /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewBank {

        @Test
        fun `should add the new bank` () {

            //given
            val newBank = Bank("abc123", 31.123, 2)

            //when
            val performPost = mockMvc.post(baseUrl){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }

            //then
            performPost
                .andDo{ print() }
                .andExpect {
                    status{ isCreated() }
                    content{ contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountNumber") { value("abc123") }
                    jsonPath("$.trust") { value("31.123") }
                    jsonPath("$.transactionFee") { value("2") }


                }
        }
    }

    @Test
    fun `should return Bad Request if bank with given account number already exists` () {

        //given
        val invalidBank = Bank("1234", 1.0, 1)

        //when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidBank)
        }

        //then
        performPost
            .andDo { print() }
            .andExpect { status { isBadRequest() } }
    }

    @Nested
    @DisplayName("should update an existing bank")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PatchExistingBank {

        @Test
        fun `should update an existing bank` () {

            //given
            val updateBank = Bank("1234", 1.0, 9)

            //when
            val performPatch = mockMvc.patch(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updateBank)
            }

            //then
            performPatch
                .andDo { print() }
                .andExpect {
                    status {
                        isOk()
                    }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(updateBank))
                    }
                }


            mockMvc.get("$baseUrl/${updateBank.accountNumber}")
                .andExpect {
                    content{
                        json(objectMapper.writeValueAsString(updateBank))
                    }
                }

        }

    }

    @Test
    fun `should return Bad Request if no bank with given account number exists` () {

        //given
        val invalidBank = Bank("doesnot exixts", 1.0, 1)

        //when
        val performPatch = mockMvc.patch(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidBank)
        }

        //then
        performPatch
            .andDo{ print() }
            .andExpect {
                status{ isNotFound() }
            }
    }


    @Test
    fun `should delete the bank with the given account numer` () {

        //given
        val accountNumber = 1234

        //when
        mockMvc.delete("$baseUrl/$accountNumber")
            .andDo { print() }
            .andExpect {
                status{ isNoContent() }
            }

        //then
        mockMvc.get("$baseUrl/$accountNumber")
            .andExpect {
                status{ isNotFound() } }

    }


    @Test
    fun `should return Not Found if no bank with given account number exists` () {
        //given
        val invalidAccountNumber = "does-not-exist"

        //when
        mockMvc.delete("$baseUrl/$invalidAccountNumber")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }
    
}