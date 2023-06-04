package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.ProductCategoryMapping;

public interface ProductCategoryMappingRepository extends JpaRepository<ProductCategoryMapping, Long> {

}