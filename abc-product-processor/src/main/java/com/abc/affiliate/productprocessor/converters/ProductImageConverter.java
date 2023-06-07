package com.abc.affiliate.productprocessor.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.abc.affiliate.productprocessor.dto.image.ProductImageBean;
import com.abc.affiliate.productprocessor.entity.ProductImage;

@Component
public class ProductImageConverter implements Converter<ProductImage, ProductImageBean> {

    @Override
    public ProductImageBean convert(ProductImage source) {
        return ProductImageBean.builder()
                .id(source.getId())
                .height(source.getHeight())
                .productId(source.getProduct().getId())
                .productName(source.getProduct().getName())
                .value(source.getValue())
                .width(source.getWidth())
                .build();
    }
}
