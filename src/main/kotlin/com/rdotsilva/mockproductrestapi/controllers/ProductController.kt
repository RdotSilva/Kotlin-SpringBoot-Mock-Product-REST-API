package com.rdotsilva.mockproductrestapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ProductController {

    /**
     * Get request to fetch all products
     */
    @GetMapping("/products")
    fun allProducts() {
        // TODO: Implement get all products
    }
}