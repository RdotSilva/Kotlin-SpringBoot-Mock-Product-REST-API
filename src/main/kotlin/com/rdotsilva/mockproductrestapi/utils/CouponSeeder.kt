package com.rdotsilva.mockproductrestapi.utils

import com.rdotsilva.mockproductrestapi.models.Coupon
import com.rdotsilva.mockproductrestapi.repositories.CouponRepository
import io.github.serpro69.kfaker.Faker
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class CouponSeeder(private val couponRepository: CouponRepository) : ApplicationRunner {
    @Value("\${seeder.enableSeeder}")
    val seederFlag: Boolean = false

    /**
     * Generate and seed 50 random coupons
     * Use the seederFlag config to enable/disable
     */
    override fun run(args: ApplicationArguments?) {
        if (seederFlag) {
            for (i in 1..50) {
                val coupon = createRandomCoupon(i)
                this.couponRepository.save(coupon)
            }
        }
    }

    /**
     * Generate a random mock coupon with unique metadata
     * @param randomNumber random number used to generate coupon metadata
     */
    fun createRandomCoupon(randomNumber: Int): Coupon {
        val faker = Faker()
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val randomString = (1..15)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")

        return Coupon(
            code = randomString,
            discount = Random.nextInt(1, 20),
            uses = Random.nextInt(1, 10),
        )
    }
}