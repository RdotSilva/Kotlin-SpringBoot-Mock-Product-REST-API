package com.rdotsilva.mockproductrestapi.repositories

import com.rdotsilva.mockproductrestapi.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface CustomerRepository : MongoRepository<Customer, String> {

    @Query("{'onMailingList': ?0}")
    fun findByOnMailingList(onMailingList: Boolean): List<Customer>
}