package com.rdotsilva.mockproductrestapi.repositories

import com.rdotsilva.mockproductrestapi.models.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface ProductRepository : MongoRepository<Product, String> {

    @Query("{'title': {\$regex: ?0, \$options: 'i' }}")
    fun searchByTitle(searchQuery: String): List<Product>
}