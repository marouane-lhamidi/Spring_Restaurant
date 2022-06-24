package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Fruit;
import com.example.demo.entities.Legume;
import com.example.demo.entities.Plat;
import com.example.demo.entities.Viand;
import com.example.demo.repo.FruitRepository;
import com.example.demo.repo.LegumeRepository;
import com.example.demo.repo.PlatRepository;
import com.example.demo.repo.ViandRepository;

@Controller
public class MenuControler {
	
	@Autowired
	PlatRepository platRepository; 
	@Autowired
	ViandRepository viandRepository; 
	@Autowired
	FruitRepository fruitRepository; 
	@Autowired
	LegumeRepository legumeRepository; 
	@RequestMapping(value = "/menu")
	public String index(Model model) {
		
		List<Plat> plats = platRepository.findAll();
		List<Fruit> fruits = fruitRepository.findAll();
		List<Legume> legumes = legumeRepository.findAll();
		List<Viand> viands = viandRepository.findAll();
		
		
		
		model.addAttribute("plats",plats);
		model.addAttribute("fruits",fruits);
		model.addAttribute("legumes",legumes);
		model.addAttribute("viands",viands);
		
		return "menu/menu";
	}
	
}
