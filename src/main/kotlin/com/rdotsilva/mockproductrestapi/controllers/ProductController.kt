package com.rdotsilva.mockproductrestapi.controllers

import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.services.ProductServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/products")
class ProductController(private val productService: ProductServiceImpl) {

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
        return ResponseEntity.ok(this.productService.getProductsInStock(inStock))
    }

    /**
     * Get request to fetch product by category
     */
    @GetMapping("/search")
    fun getProductsByCategory(@RequestParam("category", defaultValue = "") category: String): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productService.getProductsByCategory(category))
    }
}