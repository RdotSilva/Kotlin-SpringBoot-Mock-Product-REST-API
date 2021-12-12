package com.rdotsilva.mockproductrestapi.utils

import com.rdotsilva.mockproductrestapi.repositories.CustomerRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CustomerSeeder(private val customerRepository: CustomerRepository): ApplicationRunner