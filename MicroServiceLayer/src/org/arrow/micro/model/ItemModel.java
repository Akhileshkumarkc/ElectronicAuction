package org.arrow.micro.model;

public class ItemModel {

	private String name;
	private String description;
	private String imageURL;
	
	public ItemModel(String name, String description, String imageURL) {
		super();
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
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
}

