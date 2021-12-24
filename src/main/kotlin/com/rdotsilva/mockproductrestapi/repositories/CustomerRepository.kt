package com.rdotsilva.mockproductrestapi.repositories

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.models.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface CustomerRepository : MongoRepository<Customer, String> {

    @Query("{'onMailingList': ?0}")
    fun findByOnMailingList(onMailingList: Boolean): List<Customer>

    @Query("{'name': {\$regex: ?0, \$options: 'i' }}")
    fun searchByName(searchQuery: String):  List<Customer>
}