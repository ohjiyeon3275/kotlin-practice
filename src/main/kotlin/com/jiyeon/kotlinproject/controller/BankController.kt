package com.jiyeon.kotlinproject.controller

import com.jiyeon.kotlinproject.model.Bank
import com.jiyeon.kotlinproject.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController (
    private val bankService: BankService
){
    @GetMapping
    fun getBanks(): Collection<Bank> = bankService.getBanks()

}