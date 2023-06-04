package com.abc.affiliate.productprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.affiliate.productprocessor.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}