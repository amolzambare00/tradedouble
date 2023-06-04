package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.Field;

public interface FieldRepository extends JpaRepository<Field, Long> {

}