package com.abc.affiliate.productprocessor.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.abc.affiliate.productprocessor.dto.product.ProductImage;
import com.abc.affiliate.productprocessor.dto.product.Result.Products.Product;
import com.abc.affiliate.productprocessor.dto.product.Result.Products.Product.Offers.Offer;
import com.abc.affiliate.productprocessor.dto.product.Result.Products.Product.Offers.Offer.PriceHistory;
import com.abc.affiliate.productprocessor.entity.Category;
import com.abc.affiliate.productprocessor.entity.Currency;
import com.abc.affiliate.productprocessor.entity.Field;
import com.abc.affiliate.productprocessor.entity.ProductCategoryMapping;
import com.abc.affiliate.productprocessor.entity.ProductFieldMapping;
import com.abc.affiliate.productprocessor.entity.ProductOfferPrice;
import com.abc.affiliate.productprocessor.repository.CategoryRepository;
import com.abc.affiliate.productprocessor.repository.CurrencyRepository;
import com.abc.affiliate.productprocessor.repository.FieldRepository;
import com.abc.affiliate.productprocessor.repository.ProductCategoryMappingRepository;
import com.abc.affiliate.productprocessor.repository.ProductFieldMappingRepository;
import com.abc.affiliate.productprocessor.repository.ProductOfferPriceRepository;
import com.abc.affiliate.productprocessor.repository.ProductOfferRepository;
import com.abc.affiliate.productprocessor.repository.ProductRepository;
import com.abc.affiliate.productprocessor.service.ProductImageService;
import com.abc.affiliate.productprocessor.service.ProductService;

@Service
@Qualifier("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
    public CategoryRepository categoryRepository;
    
    @Autowired
    public CurrencyRepository currencyRepository;
    
    @Autowired
    public FieldRepository fieldRepository;
    
    @Autowired
    public ProductCategoryMappingRepository productCategoryMappingRepository;
    
    @Autowired
    public ProductFieldMappingRepository productFieldMappingRepository;
    
    @Autowired
    @Qualifier("productImageServiceImpl")
    public ProductImageService productImageService;
    
    @Autowired
    public ProductOfferPriceRepository productOfferPriceRepository;
    
    @Autowired
    public ProductOfferRepository productOfferRepository;
    
    @Autowired
    public ProductRepository productRepository;
    
	@Override
	@Transactional
	public Product save(Product product) {
		
		/* Save Product Table  */
		com.abc.affiliate.productprocessor.entity.Product productDb = com.abc.affiliate.productprocessor.entity.Product.builder()
				.brand(product.getBrand())
				.description(product.getDescription())
				.ean(product.getEan())
				.groupingId(product.getGroupingId())
				.isbn(product.getIsbn())
				.language(product.getLanguage())
				.manufacturer(product.getManufacturer())
				.model(product.getModel())
				.mpn(product.getMpn())
				.name(product.getName())
				.promoText(product.getPromoText())
				.shortDescription(product.getShortDescription())
				.size(product.getSize())
				.sku(product.getSku())
				.techSpecs(product.getTechSpecs())
				.upc(product.getUpc())
				.weight(product.getWeight())
				.build();
				
		com.abc.affiliate.productprocessor.entity.Product productRes = productRepository.save(productDb);
		
		/* Product Image | This xsd to java object issue | must have multiple images but it conveted to only one need to change this  */
		if (product.getProductImage() != null) {
			//TODO: Need to change once xsd fixed
			List<ProductImage> productImagesDto = new ArrayList<>(Arrays.asList(product.getProductImage()));
			productImageService.saveAll(productRes, productImagesDto);
		}
		
		/* Create Category if not present, then create category and product mapping */
		if (product.getCategories() != null && product.getCategories().getCategory() != null && product.getCategories().getCategory().size() > 0) {
			for (com.abc.affiliate.productprocessor.dto.product.Categories.Category categoryDto : product.getCategories().getCategory()) {
				Category category = categoryRepository.findOneByName(categoryDto.getName());
				if (category == null || category.getId() == 0) {
					category = new Category();
					category.setName(categoryDto.getName());
					category.setTdCategoryName(categoryDto.getTdCategoryName());
					category = categoryRepository.save(category);
				}
				
				ProductCategoryMapping productCategoryMapping = new ProductCategoryMapping();
				productCategoryMapping.setCategory(category);
				productCategoryMapping.setProduct(productRes);
				
				productCategoryMappingRepository.save(productCategoryMapping);
			}
		}
		
		
		
		/* Product Offer and price history */
		//TODO: xsd issue must conveted to multiple offer
		if (product.getOffers().getOffer() != null) {
			List<Offer> offerDtos = new ArrayList<>(Arrays.asList(product.getOffers().getOffer()));
			for (Offer offerDto : offerDtos) {
				com.abc.affiliate.productprocessor.entity.ProductOffer productOffer = new com.abc.affiliate.productprocessor.entity.ProductOffer();
				productOffer.setAvailability(offerDto.getAvailability());
				productOffer.setConditions(offerDto.getCondition());
				productOffer.setDateFormat(offerDto.getDateFormat());
				productOffer.setDeliveryTime(offerDto.getDeliveryTime());
				productOffer.setFeedId(BigInteger.valueOf(offerDto.getFeedId()));
				productOffer.setInStock(offerDto.getInStock());
				productOffer.setOfferid(offerDto.getId());
				productOffer.setProduct(productRes);
				productOffer.setProductUrl(offerDto.getProductUrl());
				productOffer.setProgramLogo(offerDto.getProgramLogo());
				productOffer.setProgramName(offerDto.getProgramName());
				productOffer.setShippingCost(offerDto.getShippingCost());
				productOffer.setSourceProductId(offerDto.getSourceProductId());
				productOffer.setWarranty(offerDto.getWarranty());
				
				productOffer = productOfferRepository.save(productOffer);
				
				/* Save offer price  */
				//TODO: xsd issue must create multiple entry 
				if (offerDto.getPriceHistory() != null) {
					List<PriceHistory> priceHistoryDtos = new ArrayList<>(Arrays.asList(offerDto.getPriceHistory()));
					for (PriceHistory priceHistoryDto : priceHistoryDtos) {
						
						/* Check Currency available if not create new */
						Currency currency = currencyRepository.findOneByCurrency(priceHistoryDto.getPrice().getCurrency());
						if (currency == null) {
							currency = new Currency();
							currency.setCurrency(priceHistoryDto.getPrice().getCurrency());
							currency = currencyRepository.save(currency);
						}
						
						ProductOfferPrice productOfferPrice = new ProductOfferPrice();
						productOfferPrice.setProductOffer(productOffer);
						productOfferPrice.setDateFormat(priceHistoryDto.getPrice().getDateFormat());
						productOfferPrice.setDate(priceHistoryDto.getPrice().getDate());
						productOfferPrice.setFkCurrencyid(BigInteger.valueOf(currency.getId()));
						productOfferPrice.setValue(priceHistoryDto.getPrice().getValue());
						
						productOfferPriceRepository.save(productOfferPrice);
					}
				}
				
			}
		}
		
		/* Create Field if not present, then create Field and product mapping */
		if (product.getFields() != null && product.getFields().getField() != null && product.getFields().getField().size() > 0) {
			for (com.abc.affiliate.productprocessor.dto.product.Fields.Field fieldDto : product.getFields().getField()) {
				Field field = fieldRepository.findOneByName(fieldDto.getName());
				if (field == null || field.getId() == 0) {
					field = new Field();
					field.setName(fieldDto.getName());
					field = fieldRepository.save(field);
				}
				
				ProductFieldMapping productFieldMapping = new ProductFieldMapping();
				productFieldMapping.setField(field);
				productFieldMapping.setProduct(productRes);
				
				productFieldMappingRepository.save(productFieldMapping);
			}
		}
		
		return product;
	}
	
	
}
