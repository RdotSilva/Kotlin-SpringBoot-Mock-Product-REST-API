package com.rdotsilva.mockproductrestapi.services

import com.rdotsilva.mockproductrestapi.models.Coupon

interface CouponService {
    fun addCoupon(coupon: Coupon)
    fun removeCoupon(id: String)
}