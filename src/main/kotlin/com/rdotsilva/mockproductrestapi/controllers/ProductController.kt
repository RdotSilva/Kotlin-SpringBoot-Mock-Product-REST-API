package com.rdotsilva.mockproductrestapi.controllers

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.ProductRepository
import com.rdotsilva.mockproductrestapi.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/products")
class ProductController(private val productService: ProductService) {

    /**
     * Get request to fetch all products
     */
    @GetMapping()
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productService.getAllProducts())
    }

    /**
     * Get request to fetch product by title
     */
    @GetMapping("/search")
    fun getProductByTitle(@RequestParam("title", defaultValue = "") title: String): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productService.getProductByTitle(title))
    }

    /**
     * Get request to fetch product by ID
     */
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): ResponseEntity<Optional<Product>> {
        return ResponseEntity.ok(this.productService.getProductById(id))
    }

    /**
     * Delete request to remove a product by ID
     */
    @DeleteMapping("/{id}")
    fun removeProduct(@PathVariable id: String) {
        this.productService.removeProduct(id)
    }

    /**
     * Get request to fetch products that are in stock
     */
    @GetMapping("/")
    fun getProductsInStock(
        @RequestParam(
            "inStock",
        ) inStock: Boolean
    ): ResponseEntity<List<Product>> {
        var allProducts: List<Product> = this.productRepository.findAll()
        var productsInStock = allProducts.filter { it.quantity > 0 }
        var productsOutOfStock = allProducts.filter { it.quantity < 0 }

        // TODO: Look into this, doesn't seem to be returning items out of stock
        return if (inStock) {
            ResponseEntity.ok(productsInStock)
        } else {
            ResponseEntity.ok(productsOutOfStock)
        }

    }
}