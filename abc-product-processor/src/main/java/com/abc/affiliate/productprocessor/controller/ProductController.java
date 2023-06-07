package com.abc.affiliate.productprocessor.controller;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abc.affiliate.productprocessor.controller.exception.ErrorResponse;
import com.abc.affiliate.productprocessor.dto.image.ProductImageBean;
import com.abc.affiliate.productprocessor.entity.ProductImage;
import com.abc.affiliate.productprocessor.service.ProductImageService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	@Qualifier("productImageServiceImpl")
    private ProductImageService productImageService;

	@GetMapping("/images/getbyproductid/{productId}")
	public ResponseEntity<List<ProductImageBean>> getProductImages(@PathVariable("productId") Long productId) {
		List<ProductImageBean> images = productImageService.getImagesByProductId(productId);
		if (images == null || images.size() == 0) {
			throw new ObjectNotFoundException(productId, "Images not available.");
		}
		return new ResponseEntity<>(images, HttpStatus.OK);
	}

    /* Controller level exception  */
    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String detail) {
            super(detail);
        }
    }
    
    /* Controller level exception handling */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MissingServletRequestParameterException ex) {
    	
    	ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    
}