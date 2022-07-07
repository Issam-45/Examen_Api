package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Personne;

import com.example.demo.repository.PersonneRepository;

@RestController
public class PersonneController {
	@Autowired
	private PersonneRepository Ipersonne;

	@PostMapping("/personne")
	public Personne addPersonne(@RequestBody Personne p) {
		List<Personne> AllPerson = Ipersonne.findAll();
		for (Personne pr:AllPerson) {
			  if(pr.getCin().equals(p.getCin()) ) { 
				  System.out.println("error");
				  throw new IllegalArgumentException("CIN existe dèja");
			  
			  } 
			  }
		Ipersonne.save(p);
		return p;

	}

	@GetMapping("/personne")
	public List<Personne> getAll() {
		List<Personne> getAllPerson = Ipersonne.findAll();
		return getAllPerson;

	}

	@PutMapping("/personne/{id}")
	public Personne updatePerson(@PathVariable Long id, @RequestBody Personne p) {

		 
		  List<Personne> AllPerson = Ipersonne.findAll();
		  for (Personne pr:AllPerson) {
		  if(pr.getCin().equals(p.getCin()) ) { 
			  System.out.println("error");
			  throw new IllegalArgumentException("CIN existe dèja");
		  
		  } 
		  }
		 
		
		p.setId(id);
		Ipersonne.save(p);
		 return(p);
		

	}

}
