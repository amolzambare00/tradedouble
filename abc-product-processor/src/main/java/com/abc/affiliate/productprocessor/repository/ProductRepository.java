package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}