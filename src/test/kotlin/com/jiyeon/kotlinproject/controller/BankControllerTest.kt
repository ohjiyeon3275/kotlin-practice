package com.jiyeon.kotlinproject.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest{

    //this is only for Test.
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return all banks`() {
        //when
        mockMvc.get("/api/banks")
            .andDo{ print() }

        //then
            .andExpect {
                status { isOk() }
                content{ contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].*.accountNumber") {
                    value("abcedf" )}

            } // lambda

    }

}