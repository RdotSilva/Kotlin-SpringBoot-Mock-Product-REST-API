package com.rdotsilva.mockproductrestapi.controllers

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class CustomerController(private val customerRepository: CustomerRepository) {

    /**
     * Get request to fetch all customers
     */
    @GetMapping("/customers")
    fun getAllCustomers(): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerRepository.findAll())
    }

    /**
     * Get request to fetch all customer emails on mailing list
     */
    @GetMapping("/customers/mailinglist")
    fun getAllCustomersOnMailingList(
        @RequestParam(
            "onMailingList",
            defaultValue = "true"
        ) onMailingList: Boolean,
    ): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerRepository.findByOnMailingList(onMailingList))
    }


}