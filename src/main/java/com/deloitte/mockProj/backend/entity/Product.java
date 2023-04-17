package com.deloitte.mockProj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="products", schema="de_kart")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;
	
	@Column
	private int seller_id;

	@Column
	private String name;
	
	@Column 
	private String description;

	@Column
	private int price;
	
	@Column
	private int discount;
	
	@Column
	private String category;
		
	@Column
	private int quantity;
	
	@Lob
	@Column(columnDefinition = "BLOB", name="image")
	private String image;

	public Product() {
		super();
	}

	public Product(int product_id, int seller_id, String name, String description, int price, int discount,
			String category, int quantity, String image) {
		super();
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", seller_id=" + seller_id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", discount=" + discount + ", category=" + category + ", quantity="
				+ quantity + ", image=" + image + "]";
	}

	
	
}
