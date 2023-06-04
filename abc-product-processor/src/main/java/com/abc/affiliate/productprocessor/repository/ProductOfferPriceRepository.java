package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.ProductOfferPrice;

public interface ProductOfferPriceRepository extends JpaRepository<ProductOfferPrice, Long> {

}