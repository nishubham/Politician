package com.shubham.service;

import java.util.List;
import java.util.Optional;

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
	
	public Politician findById(Integer id)
	{
	    return repo.findById(id).orElse(null);
	}
	
	public List<Politician> findAll(){
		return repo.findAll();
	}
	
	public Politician update(Politician poli)
	{
	    Politician existing = repo.findById(poli.getId()).orElse(null);

	    if (existing != null) 
	    {
	        return repo.save(poli);
	    }

	    return null;
	}
	
	public String deleteById(Integer id)
	{
	    Politician politician = repo.findById(id).orElse(null);

	    if (politician != null) 
	    {
	        repo.deleteById(id);
	        return "Politician deleted successfully";
	    }

	    return "Politician not found";
	}
	
	public void deleteAll(Politician poli)
	{
		repo.deleteAll();
	}
}
