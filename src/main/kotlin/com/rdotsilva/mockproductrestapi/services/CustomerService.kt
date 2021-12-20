package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

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
}