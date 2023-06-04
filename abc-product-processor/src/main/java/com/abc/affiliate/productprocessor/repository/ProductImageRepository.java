package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}