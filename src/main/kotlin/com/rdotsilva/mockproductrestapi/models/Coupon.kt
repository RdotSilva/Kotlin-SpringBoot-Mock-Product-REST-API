package com.rdotsilva.mockproductrestapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Coupon(@Id val _id: ObjectId = ObjectId.get(), var code: String, var discount: Int, var uses: Int) {
}