package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Boisson;
import com.example.demo.repo.BoissonRepository;

@Controller
@RequestMapping("/admin")
public class BoissonControler {
	@Autowired
	BoissonRepository boissonRepository; 
	
	@RequestMapping(value = "/boisson/index")
	public String index(Model model) {
		List<Boisson> boissons = boissonRepository.findAll();
		
		model.addAttribute("boissons",boissons);
		
		return "boisson/boisson";
	}
	
	
	
	@RequestMapping(value = "/boisson/save", method=RequestMethod.POST)
	public String save(Model model, Boisson b1) {
		Boisson boisson = boissonRepository.findByMarque(b1.getMarque());
		
		
		if(b1.getId() != null) {
			boissonRepository.save(b1);
		}else if(boisson != null) {
			boisson.setQuntity(b1.getQuntity() + boisson.getQuntity());
			boissonRepository.save(boisson);
		}else {
			boissonRepository.save(b1);
		}


		return "redirect:index";
	}
	
	
	
	@RequestMapping(value = "/boisson/delete")
	public String delete(Long id) {
		boissonRepository.deleteById(id);
		return "redirect:index";
	}
	
	
	@RequestMapping(value = "/boisson/edit")
	public String edit(Model model, Long id) {
		
		Boisson boisson = boissonRepository.findById(id).get();
		
		model.addAttribute("boisson",boisson);
		
		return "boisson/editBoisson";
	}
}
