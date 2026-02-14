package com.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entity.Politician;
import com.shubham.service.PoliticianService;

import io.micrometer.common.lang.NonNull;

@RestController
@RequestMapping("/politician-api")
public class PoliticianController {

	@Autowired
	private PoliticianService service;

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Politician poli) {
		String msg = service.add(poli);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Politician>> findAll() {

		List<Politician> all = service.findAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Politician> findById(@PathVariable Integer id) {

		Politician pl = service.findById(id);

		return new ResponseEntity<>(pl, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {

	 String deleteById = service.deleteById(id);

		return new ResponseEntity<>(deleteById, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {

		String message = service.deleteAll();

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
