package com.example.menu.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.menu.entities.dto.FoodDTO;
import com.example.menu.services.FoodService;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

	@Autowired
	private FoodService service;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<FoodDTO>> getAll() {
		List<FoodDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<FoodDTO> saveFood(@RequestBody FoodDTO dto) {
		dto = service.saveFood(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
