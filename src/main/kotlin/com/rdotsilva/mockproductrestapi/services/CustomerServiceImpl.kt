package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*

@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) {

    /**
     * Get a list of all customers
     */
    fun getAllCustomers(): MutableList<Customer> {
        return this.customerRepository.findAll()
    }

    /**
     * Get a list of all customer emails on mailing list
     */
    fun getAllCustomersOnMailingList(onMailingList: Boolean): List<Customer> {
        return this.customerRepository.findByOnMailingList(onMailingList)
    }

    /**
     * Get customer by ID
     */
    fun getCustomerById(id: String): Optional<Customer> {
        // Do validation here and throw exception if data is bad -> try/catch inside controller and return correct status and error message
        return this.customerRepository.findById(id)
    }

    /**
     * Create a new customer
     */
    @PostMapping()
    fun addCustomer(@RequestBody customer: Customer) {
        this.customerRepository.save(customer)
    }

    /**
     * Remove an existing customer
     */
    @DeleteMapping("/{id}")
    fun removeCustomer(@PathVariable id: String) {
        this.customerRepository.deleteById(id)
    }
}