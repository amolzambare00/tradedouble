package com.abc.affiliate.productprocessor.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.abc.affiliate.productprocessor.entity.Product;
import com.abc.affiliate.productprocessor.entity.ProductImage;
import com.abc.affiliate.productprocessor.repository.ProductImageRepository;
import com.abc.affiliate.productprocessor.service.impl.ProductImageServiceImpl;

@ExtendWith(MockitoExtension.class)
//@ActiveProfiles("test")
public class ProductImageServiceImplTests {

	@Mock
    public ProductImageRepository productImageRepository;

	@InjectMocks
	public ProductImageServiceImpl productImageServiceImpl;
	
    Product product;
    List<com.abc.affiliate.productprocessor.dto.product.ProductImage> productImages;
    
    @BeforeEach
    public void setup(){
    	product = Product.builder()
                .id(1L)
                .build();
    	
    	productImages = new ArrayList<>();
    	com.abc.affiliate.productprocessor.dto.product.ProductImage productImage = new com.abc.affiliate.productprocessor.dto.product.ProductImage();
    	productImage.setHeight((short)20);
    	productImage.setValue("image1.jpg");
    	productImage.setWidth((short)20);
    	
    	com.abc.affiliate.productprocessor.dto.product.ProductImage productImage1 = new com.abc.affiliate.productprocessor.dto.product.ProductImage();
    	productImage1.setHeight((short)20);
    	productImage1.setValue("image2.jpg");
    	productImage1.setWidth((short)20);
    	
    	productImages.add(productImage);
    	productImages.add(productImage1);
    }

    @Test
    @DisplayName("ProductImageService saveAll given ProductImagesAndProduct when SaveAll then ReturnSavedProductImages")
    public void productImageService_saveAll_givenProductImagesAndProduct_whenSaveAll_thenReturnSavedProductImagesObject(){
    	
    	// Given
    	// product & productImages 
    	List<ProductImage> productImageEntityExpected = new ArrayList<>();
    	for (int i=1; i <= productImages.size(); i++) {
        	com.abc.affiliate.productprocessor.dto.product.ProductImage productImageTemp = productImages.get(i-1);
        	productImageEntityExpected.add(ProductImage.builder().height(productImageTemp.getHeight()).width(productImageTemp.getWidth())
    				.id(i).product(product)
    				.value(productImageTemp.getValue()).build());
		}

    	// When
    	Mockito.when(productImageRepository.save(any())).thenReturn(productImageEntityExpected.get(0), productImageEntityExpected.get(1));
    	
    	// Then
    	List<ProductImage> productImagesReturn = productImageServiceImpl.saveAll(product, productImages);
    	
    	Assertions.assertThat(productImagesReturn).isNotNull();
    	Assertions.assertThat(productImagesReturn.size()).isEqualTo(2);
    	Assertions.assertThat(productImagesReturn.get(0).getId()).isEqualTo(1l);
    	
    }	
    
    
    
    
}
