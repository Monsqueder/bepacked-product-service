package com.bepacked.productservice.exception

class MissingFieldException(fieldName: String) : RuntimeException("Missing field with name $fieldName")
