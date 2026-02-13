package com.shubham.service;

import com.shubham.entity.Politician;
import com.shubham.repository.PoliticianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliticianService {

    @Autowired
    private PoliticianRepository politicianRepository;


    public Politician savePolitician(Politician politician) {
         return politicianRepository.save(politician);
    }

   public Politician findById(Integer id) {
        return politicianRepository.findById(id).get();
   }


}
