package com.rdotsilva.mockproductrestapi.services


import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.ProductRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    /**
     * Get a list of all products
     */
    override fun getAllProducts(): MutableList<Product> {
        return this.productRepository.findAll()
    }

    /**
     * Get a list of all products matching a specific title
     */
    override fun getProductByTitle(title: String): List<Product> {
        return this.productRepository.searchByTitle(title)
    }

    /**
     * Get a product by ID
     */
    override fun getProductById(id: String): Optional<Product> {
        return this.productRepository.findById(id)
    }

    /**
     * Delete a product by ID
     */
    override fun removeProduct(id: String) {
        return this.productRepository.deleteById(id)
    }

}