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
 * The persistent class for the fields database table.
 * 
 */
@Entity
@Table(name="fields")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Field implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(length=256)
	private String name;

	//bi-directional many-to-one association to ProductFieldMapping
	@OneToMany(mappedBy="field")
	@ToString.Exclude
	private List<ProductFieldMapping> productFieldMappings;

}