package com.bepacked.productservice.mapper

import com.bepacked.productservice.dto.ProductRequestDto
import com.bepacked.productservice.dto.ProductResponseDto
import com.bepacked.productservice.exception.MissingFieldException
import com.bepacked.productservice.model.Product

fun Product.toProductResponseDto() : ProductResponseDto = ProductResponseDto(
    id = id ?: throw MissingFieldException("id"),
    name = name
)

fun ProductRequestDto.toProduct(id: Long? = null) : Product = Product(name = name, id = id)