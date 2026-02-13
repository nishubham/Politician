package com.shubham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shubham.entity.Politician;

@Repository
public interface PoliticianRepository extends JpaRepository<Politician, Integer> {

}
