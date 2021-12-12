package com.rdotsilva.mockproductrestapi.utils

import com.rdotsilva.mockproductrestapi.models.Customer
import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import io.github.serpro69.kfaker.Faker
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CustomerSeeder(private val customerRepository: CustomerRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        for (i in 1..50) {
            val customer = createRandomCustomer(i)
            this.customerRepository.save(customer)
        }
    }

    /**
     * Generate a random mock Customer with unique metadata
     * @param randomNumber random number used to generate Product metadata
     */
    fun createRandomCustomer(randomNumber: Int): Customer {
        val faker = Faker()
        return Customer(
            firstName = faker.name.firstName(),
            lastName = faker.name.lastName()
        )
    }
}