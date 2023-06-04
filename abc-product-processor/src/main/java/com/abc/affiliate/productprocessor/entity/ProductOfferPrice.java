package com.abc.affiliate.productprocessor.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.abc.affiliate.productprocessor.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the product_offer_price database table.
 * 
 */
@Entity
@Table(name="product_offer_price")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ProductOfferPrice extends Auditable<String> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	private BigInteger date;

	@Column(length=512)
	private String dateFormat;

	@Column(name="fk_currencyid")
	private BigInteger fkCurrencyid;

	@Column(precision=10)
	private BigDecimal value;

	//bi-directional many-to-one association to ProductOffer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_offerid", nullable=false)
	@ToString.Exclude
	private ProductOffer productOffer;


}