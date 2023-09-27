package com.example.menu.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.menu.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
