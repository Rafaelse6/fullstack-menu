package com.example.menu.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.menu.entities.Food;
import com.example.menu.entities.dto.FoodDTO;
import com.example.menu.factory.FoodFactory;
import com.example.menu.repositores.FoodRepository;

@ExtendWith(SpringExtension.class)
public class FoodServiceTests {

	@InjectMocks
	private FoodService service;

	@Mock
	private FoodRepository repository;

	private Food food;
	private FoodDTO foodDTO;
	private List<Food> list;

	@BeforeEach
	void setUp() throws Exception {
		food = FoodFactory.createFood();
		foodDTO = new FoodDTO(food);

		list = new ArrayList<>();
		list.add(food);

		Mockito.when(repository.findAll()).thenReturn(list);

		Mockito.when(repository.save(any())).thenReturn(food);
	}

	@Test
	public void findAllShouldReturnListFoodDTO() {
		List<FoodDTO> result = service.findAll();

		Assertions.assertEquals(result.size(), 1);
		Assertions.assertEquals(result.get(0).getId(), food.getId());
		Assertions.assertEquals(result.get(0).getTitle(), food.getTitle());
		Assertions.assertEquals(result.get(0).getImage(), food.getImage());
		Assertions.assertEquals(result.get(0).getPrice(), food.getPrice());
	}

	@Test
	public void insertShouldReturnFoodDTO() {
		FoodDTO result = service.saveFood(foodDTO);

		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), food.getId());
	}
}
