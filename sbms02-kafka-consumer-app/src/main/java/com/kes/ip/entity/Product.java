package com.kes.ip.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PRODUCT_DTLS")
public class Product {

	@Id
	@Column(name = "PROD_ID")
	private Integer productId;

	@Column(name = "PROD_NAME")
	private String productName;

	@Column(name = "PROD_COST")
	private Double productCost;

	@Column(name = "PROD_DESC")
	private String productDescription;
}
