package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Product
import java.util.*

interface ProductService {
    fun getAllProducts(): MutableList<Product>
    fun getProductByTitle(title: String): List<Product>
    fun getProductById(id: String): Optional<Product>
    fun removeProduct(id: String): Unit
    fun getProductsInStock(inStock: Boolean): List<Product>
}