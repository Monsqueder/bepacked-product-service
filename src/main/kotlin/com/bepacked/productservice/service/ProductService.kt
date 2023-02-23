package com.bepacked.productservice.service

import com.bepacked.productservice.dto.ProductRequestDto
import com.bepacked.productservice.dto.ProductResponseDto
import org.springframework.stereotype.Service

@Service
interface ProductService {

    fun getProducts() : List<ProductResponseDto>

    fun getProductById(id: Long) : ProductResponseDto

    fun createProduct(productRequestDto: ProductRequestDto)

    fun updateProduct(id: Long, productRequestDto: ProductRequestDto)

    fun deleteProductById(id: Long)
}