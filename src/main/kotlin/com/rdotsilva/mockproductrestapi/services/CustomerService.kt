package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    /**
     * Get a list of all customers
     */
    fun getAllCustomers(): MutableList<Customer> {
        return this.customerRepository.findAll()
    }
}