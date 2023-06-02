package com.abc.affiliate.dataadapter.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.abc.affiliate.dataadapter.dto.product.Result.Products.Product;


@Component
public class ProductProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product product) throws Exception {
        System.out.println(product.getEan());
    	return product;
    }
}
