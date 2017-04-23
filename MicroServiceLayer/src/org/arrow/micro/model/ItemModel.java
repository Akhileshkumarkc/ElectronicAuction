package org.arrow.micro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemModel {
	
	@Column(name="Itemid")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "itemids")
	@SequenceGenerator(name="itemids",sequenceName="itemids" ,allocationSize = 1)
	@Id
	private int Id;
	private String name;
	private String description;
	private String imageURL;
	private String category;
	
	public ItemModel(String name, String description, String imageURL) {
		super();
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
	}
	
	public ItemModel() {
		// TODO Auto-generated constructor stub
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
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

