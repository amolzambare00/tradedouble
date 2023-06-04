package com.abc.affiliate.productprocessor.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the product_offers database table.
 * 
 */
@Entity
@Table(name="product_offers")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ProductOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(length=512)
	private String availability;

	@Column(length=512)
	private String conditions;

	@Column(length=256)
	private String dateFormat;

	@Column(length=512)
	private String deliveryTime;

	private BigInteger feedId;

	private int inStock;

	private BigInteger modifiedDate;

	@Column(length=256)
	private String offerid;

	@Column(length=512)
	private String productUrl;

	@Column(length=512)
	private String programLogo;

	@Column(length=512)
	private String programName;

	@Column(length=512)
	private String shippingCost;

	@Column(length=512)
	private String sourceProductId;

	@Column(length=512)
	private String warranty;

	//bi-directional many-to-one association to ProductOfferPrice
	@OneToMany(mappedBy="productOffer")
	@ToString.Exclude
	private List<ProductOfferPrice> productOfferPrices;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_productid", nullable=false)
	@ToString.Exclude
	private Product product;

}