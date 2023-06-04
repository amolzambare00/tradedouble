package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}