package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Customer
import java.util.*

interface CustomerService {
    fun getAllCustomers(): MutableList<Customer>
    fun getAllCustomersOnMailingList(onMailingList: Boolean): List<Customer>
    fun getCustomerById(id: String): Optional<Customer>
    fun addCustomer(customer: Customer)
    fun removeCustomer(id: String)
}