package com.rdotsilva.mockproductrestapi.controllers

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/customers")
class CustomerController(private val customerRepository: CustomerRepository) {

    /**
     * Get request to fetch all customers
     */
    @GetMapping()
    fun getAllCustomers(): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerRepository.findAll())
    }

    /**
     * Get request to fetch all customer emails on mailing list
     */
    @GetMapping("/mailinglist")
    fun getAllCustomersOnMailingList(
        @RequestParam(
            "onMailingList",
            defaultValue = "true"
        ) onMailingList: Boolean,
    ): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerRepository.findByOnMailingList(onMailingList))
    }

    @GetMapping("/customer")
    fun getCustomerById(@RequestParam("id") id: String): ResponseEntity<Optional<Customer>> {
        return ResponseEntity.ok(this.customerRepository.findById(id))
    }

    @PostMapping()
    fun addCustomer(@RequestBody customer: Customer) {
        this.customerRepository.save(customer)
    }

    @DeleteMapping("/{id}")
    fun removeCustomer(@PathVariable id: String) {
        this.customerRepository.deleteById(id)
    }
}