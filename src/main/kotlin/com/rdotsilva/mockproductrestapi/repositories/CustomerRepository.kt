package com.rdotsilva.mockproductrestapi.repositories

import com.rdotsilva.mockproductrestapi.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<Customer, String>