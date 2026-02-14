package com.shubham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.entity.Politician;
import com.shubham.repository.PoliticianRepository;

@Service
public class PoliticianService {
	
	@Autowired
	private PoliticianRepository repo;
	

	public String add(Politician poli){
		Politician save = repo.save(poli);
		return save.getName()+" is save";
	}
	
	public List<Politician> findAll(){
		return repo.findAll();
	}

}
