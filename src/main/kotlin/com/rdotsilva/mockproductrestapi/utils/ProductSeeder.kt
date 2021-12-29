package com.rdotsilva.mockproductrestapi.utils

import com.rdotsilva.mockproductrestapi.models.Product
import com.rdotsilva.mockproductrestapi.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ProductSeeder(private val productRepository: ProductRepository) : ApplicationRunner {
    @Value("\${seeder.enableSeeder}")
    val seederFlag: Boolean = false
    val productCategories = listOf("electronics", "digital", "household", "edible", "health")

    /**
     * Generate and seed 50 random products
     * Use the seederFlag config to enable/disable
     */
    override fun run(args: ApplicationArguments?) {
        if (seederFlag) {
            for (i in 1..50) {
                val product = createRandomProduct(i)
                this.productRepository.save(product)
            }
        }
    }

    /**
     * Generate a random mock Product with unique metadata
     * @param randomNumber random number used to generate Product metadata
     */
    fun createRandomProduct(randomNumber: Int): Product {
        return Product(
            title = "Title # $randomNumber",
            category = productCategories.random(),
            description = "Description # ${randomNumber + 1}",
            image = "http://lorempixel.com/200/200?=${Random.nextInt(10000)}",
            price = Random.nextInt(10, 100),
            quantity = Random.nextInt(0, 25)
        )
    }
}