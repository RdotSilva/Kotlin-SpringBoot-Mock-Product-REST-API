package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Product

interface ProductService {
    fun getAllProducts(): List<Product>
    fun getProductByTitle(title: String): Product
    fun getProductById(id: String): Product
    fun removeProduct(id: String): Unit
    fun getProductsInStock(inStock: Boolean): List<Product>
}