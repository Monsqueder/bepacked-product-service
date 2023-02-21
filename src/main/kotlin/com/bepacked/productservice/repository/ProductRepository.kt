package com.bepacked.productservice.repository

import com.bepacked.productservice.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>