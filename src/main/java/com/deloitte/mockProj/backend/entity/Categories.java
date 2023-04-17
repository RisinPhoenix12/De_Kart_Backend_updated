package com.deloitte.mockProj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table(name="categories", schema="de_kart")
public class Categories {
	
	@Id
	private String name;
	
	@Column
	private String description;
	
	@Lob
	@Column(columnDefinition = "BLOB", name="category_image")
	private String image;

	public Categories() {
		super();
	}

	public Categories(String name, String description, String image) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Categories [name=" + name + ", description=" + description + ", image=" + image + "]";
	}

	

	
}
