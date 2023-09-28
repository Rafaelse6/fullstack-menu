package com.example.menu.factory;

import com.example.menu.entities.Food;

public class FoodFactory {
	public static Food createFood() {
		return new Food(1L, "Pizza", "www.example.com", 20);
	}

	public static Food createFood(Long id, String title, String image, Integer price) {
		return new Food(1L, "Pizza", "www.example.com", 20);
	}
}
