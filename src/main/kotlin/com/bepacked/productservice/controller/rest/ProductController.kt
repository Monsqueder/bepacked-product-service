package com.bepacked.productservice.controller.rest

import com.bepacked.productservice.dto.ProductRequestDto
import com.bepacked.productservice.dto.ProductResponseDto
import com.bepacked.productservice.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(val productService: ProductService) {

    @GetMapping
    fun getProducts(): List<ProductResponseDto> {
        return productService.getProducts()
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable("id") id: Long): ProductResponseDto? {
        return productService.getProductById(id)
    }

    @PostMapping
    fun createProduct(@RequestBody product: ProductRequestDto) {
        productService.createProduct(product)
    }

    @PutMapping("/{id}")
    fun updateProductById(@PathVariable("id") id: Long, @RequestBody product: ProductRequestDto) {
        productService.updateProduct(id, product)
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable("id") id: Long) {
        productService.deleteProductById(id)
    }

}