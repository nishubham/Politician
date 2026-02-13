package com.shubham.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entity.Politician;
import com.shubham.service.PoliticianService;

@RestController
@RequestMapping("/politician-api")
public class PoliticianControler {

	@Autowired
	private PoliticianService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Politician poli){
		String msg=service.add(poli);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Politician>> findAll(){
		
		List<Politician> all = service.findAll();
		return new ResponseEntity<>(all,HttpStatus.OK);
	}
}
