package com.abc.affiliate.productprocessor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(length=512)
	private String name;

	@Column(length=512)
	private String tdCategoryName;

	//bi-directional many-to-one association to ProductCategoryMapping
	@OneToMany(mappedBy="category")
    @ToString.Exclude
	private List<ProductCategoryMapping> productCategoryMappings;

}