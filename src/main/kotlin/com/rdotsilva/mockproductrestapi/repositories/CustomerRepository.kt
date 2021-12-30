package com.rdotsilva.mockproductrestapi.repositories

import com.rdotsilva.mockproductrestapi.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface CustomerRepository : MongoRepository<Customer, String> {

    @Query("{'onMailingList': ?0}")
    fun findByOnMailingList(onMailingList: Boolean): List<Customer>

    @Query("{'firstName': {\$regex: ?0, \$options: 'i' }}")
    fun searchByFirstName(searchQuery: String): List<Customer>

    @Query("{'lastName': {\$regex: ?0, \$options: 'i' }}")
    fun searchByLastName(searchQuery: String): List<Customer>

    @Query("{'postCode': {\$regex: ?0, \$options: 'i' }}")
    fun searchByPostCode(searchQuery: String): List<Customer>
}