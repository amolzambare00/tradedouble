package com.abc.affiliate.productprocessor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the product_field_mapping database table.
 * 
 */
@Entity
@Table(name="product_field_mapping")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ProductFieldMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(length=512)
	private String value;

	//bi-directional many-to-one association to Field
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_fieldid", nullable=false)
	@ToString.Exclude
	private Field field;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_productid", nullable=false)
	@ToString.Exclude
	private Product product;

}