package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Fruit;
import com.example.demo.repo.FruitRepository;

@Controller
public class FruitControler {
	@Autowired
	FruitRepository fruitRepository; 
	
	@RequestMapping(value = "/admin/fruit/index")
	public String index(Model model) {
		List<Fruit> fruits = fruitRepository.findAll();
		
		model.addAttribute("fruits",fruits);
		
		return "fruit/fruit";
	}
	
	
	
	@RequestMapping(value = "/admin/fruit/save", method=RequestMethod.POST)
	public String save(Model model, Fruit f1) {
		Fruit fruit = fruitRepository.findByNom(f1.getNom());
		
		
		if(f1.getId() != null) {
			fruitRepository.save(f1);
		}else if(fruit != null) {
			fruit.setQuntity(f1.getQuntity() + fruit.getQuntity());
			fruitRepository.save(fruit);
		}else {
			fruitRepository.save(f1);
		}


		return "redirect:/admin/fruit/index";
	}
	
	
	
	@RequestMapping(value = "/admin/fruit/delete")
	public String delete(Long id) {
		fruitRepository.deleteById(id);
		return "redirect:/admin/fruit/index";
	}
	
	
	@RequestMapping(value = "/admin/fruit/edit")
	public String edit(Model model, Long id) {
		
		Fruit fruit = fruitRepository.findById(id).get();
		
		model.addAttribute("fruit",fruit);
		
		return "fruit/editFruit";
	}
}
