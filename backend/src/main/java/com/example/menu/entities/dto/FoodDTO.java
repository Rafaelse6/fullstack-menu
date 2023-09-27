package com.example.menu.entities.dto;

import com.example.menu.entities.Food;

public class FoodDTO {

	private Long id;

	private String title;
	private String image;
	private Integer price;

	public FoodDTO() {
	}

	public FoodDTO(Long id, String title, String image, Integer price) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
	}

	public FoodDTO(Food entity) {
		id = entity.getId();
		title = entity.getTitle();
		image = entity.getImage();
		price = entity.getPrice();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public Integer getPrice() {
		return price;
	}
}
