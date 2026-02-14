package com.shubham.controler;

import java.util.List;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull Politician> getById(@PathVariable Long id){

            Politician pl=  service.findById(id);

        return new ResponseEntity<>(pl,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Politician> deleteById(@PathVariable Long id){

             Politician pl= service.deleteById(id);

      return new ResponseEntity<>(pl,HttpStatus.OK);
    }
@DeleteMapping("/deleteAll")
    public ResponseEntity<@NonNull String>deleteAll(){

        String message=service.deleteAll();

        return new ResponseEntity<>(message,HttpStatus.OK);
    }





}
