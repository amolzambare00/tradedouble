package com.abc.affiliate.productprocessor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.affiliate.productprocessor.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
	
	List<ProductImage> findByProduct_Id(Long productId);
	
	/* Alternative way to write query */
	@Query("from ProductImage pi where pi.product.id=:id")
	List<ProductImage> findByProductId(@Param("id") Long id);

}