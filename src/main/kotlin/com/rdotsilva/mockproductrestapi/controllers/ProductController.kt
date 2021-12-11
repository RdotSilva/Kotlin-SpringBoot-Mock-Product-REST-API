package com.rdotsilva.mockproductrestapi.controllers

import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.ProductRepository
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ProductController(private val productRepository: ProductRepository) {

    /**
     * Get request to fetch all products
     */
    @GetMapping("/products")
    fun allProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productRepository.findAll())
    }

    @GetMapping("/products")
    fun getProductByTitle(@RequestParam("title", defaultValue = "") title: String,): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productRepository.findAll())
    }
}