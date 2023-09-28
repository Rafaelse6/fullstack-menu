package com.example.menu.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class FoodControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void findAllShouldReturnListOfFoodDTO() throws Exception {

		ResultActions result = mockMvc.perform(get("/food"));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.[0].id").value(1L));
		result.andExpect(jsonPath("$.[0].title").value("Sandwich"));
		result.andExpect(jsonPath("$.[0].image").value("www.google.com"));
		result.andExpect(jsonPath("$.[0].price").value(40));
	}
}
