package com.abc.affiliate.productprocessor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.abc.affiliate.productprocessor.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Product extends Auditable<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(length=256)
	private String brand;

	@Lob
	private String description;

	@Column(length=128)
	private String ean;

	@Column(length=512)
	private String groupingId;

	@Column(length=128)
	private String isbn;

	@Column(length=128)
	private String language;

	@Column(length=256)
	private String manufacturer;

	@Column(length=128)
	private String model;

	@Column(length=128)
	private String mpn;

	@Column(nullable=false, length=512)
	private String name;

	@Column(length=512)
	private String promoText;

	@Column(length=512)
	private String shortDescription;

	@Column(length=16)
	private String size;

	@Column(length=256)
	private String sku;

	@Column(length=256)
	private String techSpecs;

	@Column(length=128)
	private String upc;

	@Column(length=16)
	private String weight;

	//bi-directional many-to-one association to ProductCategoryMapping
	@OneToMany(mappedBy="product")
	@ToString.Exclude
	private List<ProductCategoryMapping> productCategoryMappings;

	//bi-directional many-to-one association to ProductFieldMapping
	@OneToMany(mappedBy="product")
	@ToString.Exclude
	private List<ProductFieldMapping> productFieldMappings;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="product")
	@ToString.Exclude
	private List<ProductImage> productImages;

	//bi-directional many-to-one association to ProductOffer
	@OneToMany(mappedBy="product")
	@ToString.Exclude
	private List<ProductOffer> productOffers;

}