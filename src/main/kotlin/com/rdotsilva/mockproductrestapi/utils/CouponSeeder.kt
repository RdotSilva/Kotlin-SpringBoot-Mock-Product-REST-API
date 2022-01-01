package com.rdotsilva.mockproductrestapi.utils

import com.rdotsilva.mockproductrestapi.repositories.CouponRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CouponSeeder(private val couponRepository: CouponRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        TODO("Not yet implemented")
    }
}