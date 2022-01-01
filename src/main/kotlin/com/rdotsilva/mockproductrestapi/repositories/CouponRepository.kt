package com.rdotsilva.mockproductrestapi.repositories

import com.rdotsilva.mockproductrestapi.models.Coupon
import org.springframework.data.mongodb.repository.MongoRepository

interface CouponRepository : MongoRepository<Coupon, String> {
}