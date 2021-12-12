package com.rdotsilva.mockproductrestapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Customer(@Id val _id: ObjectId = ObjectId.get(), var firstName: String, var lastName: String)