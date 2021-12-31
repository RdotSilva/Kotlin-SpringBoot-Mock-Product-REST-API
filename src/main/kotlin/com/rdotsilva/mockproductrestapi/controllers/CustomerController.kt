package com.rdotsilva.mockproductrestapi.controllers

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.services.CustomerServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/customers")
class CustomerController(private val customerService: CustomerServiceImpl) {

    /**
     * Get request to fetch all customers
     */
    @GetMapping()
    fun getAllCustomers(): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerService.getAllCustomers())
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
        return ResponseEntity.ok(this.customerService.getAllCustomersOnMailingList(onMailingList))
    }

    /**
     * Get request to fetch customer by ID
     */
    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String): ResponseEntity<Optional<Customer>> {
        return ResponseEntity.ok(this.customerService.getCustomerById(id))
    }

    /**
     * Post request to add a new customer
     */
    @PostMapping()
    fun addCustomer(@RequestBody customer: Customer) {
        this.customerService.addCustomer(customer)
    }

    /**
     * Delete request to remove a customer by ID
     */
    @DeleteMapping("/{id}")
    fun removeCustomer(@PathVariable id: String) {
        this.customerService.removeCustomer(id)
    }

    /**
     * Get request to fetch customers by first name
     */
    @GetMapping("/")
    fun getCustomersByFirstName(
        @RequestParam(
            "firstName",
            defaultValue = ""
        ) firstName: String,
    ): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerService.getCustomersByFirstName(firstName))
    }

    /**
     * Get request to fetch customers by last name
     */
    @GetMapping("/")
    fun getCustomerByLastName(
        @RequestParam(
            "lastName",
            defaultValue = ""
        ) lastName: String,
    ): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerService.getCustomersByLastName(lastName))
    }

    /**
     * Get request to fetch customers post code
     */
    @GetMapping("/")
    fun getCustomersByPostCode(
        @RequestParam(
            "postCode",
            defaultValue = ""
        ) postCode: String,
    ): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(this.customerService.getCustomersByLastName(postCode))
    }
}