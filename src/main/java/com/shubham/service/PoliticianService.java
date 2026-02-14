package com.shubham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.entity.Politician;
import com.shubham.exception.PoliticianResourseNotFound;
import com.shubham.repository.PoliticianRepository;

@Service
public class PoliticianService {
	
	@Autowired
	private PoliticianRepository repo;
	

	public String add(Politician poli){
		Politician save = repo.save(poli);
		return save.getName()+" is save";
	}
	
	public Politician findById(Integer id)
	{
	    return repo.findById(id).orElseThrow(() -> new PoliticianResourseNotFound("Id is not found !!!"));
	}
	
	public List<Politician> findAll(){
		return repo.findAll();
	}
	
	public Politician update(Politician poli)
	{
	    Politician existing = repo.findById(poli.getId()).orElseThrow(() -> new PoliticianResourseNotFound("Id is not found !!!"));

	    return repo.save(existing);
	}
	
	public String deleteById(Integer id)
	{
	    Politician politician = repo.findById(id).orElseThrow(() -> new PoliticianResourseNotFound("Id is not found !!!"));

	    repo.delete(politician);
	    return politician.getName()+"is deleted Successfully !!!!";
	}
	
	public String deleteAll()
	{
		repo.deleteAll();
		return "Deleted all Politician Data";
	}
}
