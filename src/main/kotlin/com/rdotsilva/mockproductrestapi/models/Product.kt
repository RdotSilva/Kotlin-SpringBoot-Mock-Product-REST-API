package com.rdotsilva.mockproductrestapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document()
class Product(@Id val _id: ObjectId = ObjectId.get(), val title: String, val description: String, val image: String, val price: Int) {
}