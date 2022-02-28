package com.jiyeon.kotlinproject.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
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
            } // lambda


        /**
         * printed...-->
         *
        MockHttpServletRequest:
        HTTP Method = GET
        Request URI = /api/banks
        Parameters = {}
        Headers = []
        Body = null
        Session Attrs = {}

        Handler:
        Type = com.jiyeon.kotlinproject.controller.BankController
        Method = com.jiyeon.kotlinproject.controller.BankController#getBanks()

        Async:
        Async started = false
        Async result = null

        Resolved Exception:
        Type = null

        ModelAndView:
        View name = null
        View = null
        Model = null

        FlashMap:
        Attributes = null

        MockHttpServletResponse:
        Status = 200
        Error message = null
        Headers = [Content-Type:"application/json"]
        Content type = application/json
        Body = [{"accountNumber":"1234","trust":3.14,"transactionFee":17},{"accountNumber":"1010","trust":17.0,"transactionFee":0},{"accountNumber":"5678","trust":0.0,"transactionFee":100}]
        Forwarded URL = null
        Redirected URL = null
        Cookies = []
        */
    }

}