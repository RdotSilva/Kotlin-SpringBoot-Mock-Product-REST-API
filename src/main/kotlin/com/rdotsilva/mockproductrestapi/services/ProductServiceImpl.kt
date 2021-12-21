package com.rdotsilva.mockproductrestapi.services


import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    /**
     * Get a list of all products
     */
    override fun getAllProducts(): MutableList<Product> {
        return this.productRepository.findAll()
    }

}