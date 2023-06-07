package com.abc.affiliate.productprocessor.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.abc.affiliate.productprocessor.entity.Product;
import com.abc.affiliate.productprocessor.entity.ProductImage;

@DataJpaTest
@AutoConfigureTestDatabase
//@ActiveProfiles("test")
public class ProductImageRepositoryTests {

	@Autowired
	private ProductImageRepository productImageRepository;

	@Test
	@Sql("/init_data.sql")
	public void ProductImageRepository_findByProduct_Id_ReturnProductImage() {
		// Arrage data
		Product product = Product.builder().id(1).build();
		
		ProductImage productImage = ProductImage.builder().height(20)
				.product(product).value("image.jpg").width(20)
				.build();

		// Act
		productImageRepository.save(productImage);
		List<ProductImage> productImagesQueryResult = productImageRepository.findByProduct_Id(product.getId());
		
		// Assert
		Assertions.assertThat(productImagesQueryResult).isNotNull();
		Assertions.assertThat(productImagesQueryResult.size()).isEqualTo(3);
		Assertions.assertThat(productImagesQueryResult.get(2).getValue()).isEqualTo("image.jpg");
	}
	
	@Test
	@Sql("/init_data.sql")
	public void ProductImageRepository_findByProductId_ReturnProductImage() {
		// Arrage data
		Product product = Product.builder().id(1).build();
		
		ProductImage productImage = ProductImage.builder().height(20)
				.product(product).value("image.jpg").width(20)
				.build();

		// Act
		productImageRepository.save(productImage);
		List<ProductImage> productImagesQueryResult = productImageRepository.findByProductId(product.getId());
		
		// Assert
		Assertions.assertThat(productImagesQueryResult).isNotNull();
		Assertions.assertThat(productImagesQueryResult.size()).isEqualTo(3);
		Assertions.assertThat(productImagesQueryResult.get(2).getValue()).isEqualTo("image.jpg");
	}
	
	@Test
	@Sql("/init_data.sql")
	public void ProductImageRepository_Save_ReturnSavedProductImage() {
		// Arrage data
		Product product = Product.builder().id(1).build();
		
		ProductImage productImage = ProductImage.builder().height(20)
				.product(product).value("image.jpg").width(20)
				.build();

		// Act
		ProductImage savedProductImage = productImageRepository.save(productImage);

		// Assert
		Assertions.assertThat(savedProductImage).isNotNull();
		Assertions.assertThat(savedProductImage.getId()).isGreaterThan(0);
		//Assertions.assertThat(savedProductImage.getProduct().getId()).isEqualTo(1);
		
	}

}
