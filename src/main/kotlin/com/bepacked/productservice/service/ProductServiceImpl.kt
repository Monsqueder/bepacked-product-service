package com.bepacked.productservice.service

import com.bepacked.productservice.dto.ProductRequestDto
import com.bepacked.productservice.dto.ProductResponseDto
import com.bepacked.productservice.exception.EntityNotFoundException
import com.bepacked.productservice.mapper.toProduct
import com.bepacked.productservice.mapper.toProductResponseDto
import com.bepacked.productservice.model.Product
import com.bepacked.productservice.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    override fun getProducts(): List<ProductResponseDto> {
        return productRepository.findAll().map { it.toProductResponseDto() }
    }

    override fun getProductById(id: Long): ProductResponseDto {
        return findProductById(id).toProductResponseDto()
    }

    override fun createProduct(productRequestDto: ProductRequestDto) {
        productRepository.save(productRequestDto.toProduct())
    }

    override fun updateProduct(id: Long, productRequestDto: ProductRequestDto) {
        productRepository.save(productRequestDto.toProduct(findProductById(id).id))
    }

    override fun deleteProductById(id: Long) {
        productRepository.delete(findProductById(id))
    }

    private fun findProductById(id: Long) : Product {
        return productRepository.findById(id).orElseThrow {throw EntityNotFoundException("Product with id $id not found!")}
    }
}