package com.example.menu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.menu.entities.Food;
import com.example.menu.entities.dto.FoodDTO;
import com.example.menu.repositores.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Transactional(readOnly = true)
	public List<FoodDTO> findAll() {
		List<Food> list = foodRepository.findAll();
		return list.stream().map(x -> new FoodDTO(x)).toList();
	}

	@Transactional
	public FoodDTO saveFood(FoodDTO dto) {
		Food entity = new Food();
		copyDtoToEntity(dto, entity);
		entity = foodRepository.save(entity);

		return new FoodDTO(entity);
	}

	public void copyDtoToEntity(FoodDTO dto, Food entity) {
		entity.setTitle(dto.getTitle());
		entity.setPrice(dto.getPrice());
		entity.setImage(dto.getImage());
	}
}
