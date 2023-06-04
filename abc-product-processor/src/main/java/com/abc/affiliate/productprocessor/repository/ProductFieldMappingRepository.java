package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.ProductFieldMapping;

public interface ProductFieldMappingRepository extends JpaRepository<ProductFieldMapping, Long> {

}