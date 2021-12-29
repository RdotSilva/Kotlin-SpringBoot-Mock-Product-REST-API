package com.rdotsilva.mockproductrestapi.services


import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.ProductRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
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
     * Get a list of all matching a specific category
     */
    override fun getProductsByCategory(): List<Product> {
        return this.productRepository.searchByCategory()
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

    /**
     * Get products that are in stock or out of stock
     */
    override fun getProductsInStock(inStock: Boolean): List<Product> {
        var allProducts: List<Product> = this.productRepository.findAll()
        var productsInStock = allProducts.filter { it.quantity > 0 }
        var productsOutOfStock = allProducts.filter { it.quantity < 0 }

        // TODO: Look into this, doesn't seem to be returning items out of stock
        return if (inStock) {
            productsInStock
        } else {
            productsOutOfStock
        }

    }

}