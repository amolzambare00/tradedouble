package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.ProductOffer;

public interface ProductOfferRepository extends JpaRepository<ProductOffer, Long> {

}