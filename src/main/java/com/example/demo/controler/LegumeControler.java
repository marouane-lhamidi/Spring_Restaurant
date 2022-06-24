package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Legume;
import com.example.demo.repo.LegumeRepository;

@Controller
public class LegumeControler {
	@Autowired
	LegumeRepository legumeRepository; 
	
	@RequestMapping(value = "/admin/legume/index")
	public String index(Model model) {
		List<Legume> legumes = legumeRepository.findAll();
		
		model.addAttribute("legumes",legumes);
		
		return "legume/legume";
	}
	
	
	
	@RequestMapping(value = "/admin/legume/save", method=RequestMethod.POST)
	public String save(Model model, Legume l1) {
		Legume legume = legumeRepository.findByNom(l1.getNom());
		
		
		if(l1.getId() != null) {
			legumeRepository.save(l1);
		}else if(legume != null) {
			legume.setQuntity(l1.getQuntity() + legume.getQuntity());
			legumeRepository.save(legume);
		}else {
			legumeRepository.save(l1);
		}


		return "redirect:/legume/index";
	}
	
	
	
	@RequestMapping(value = "/admin/legume/delete")
	public String delete(Long id) {
		legumeRepository.deleteById(id);
		return "redirect:/legume/index";
	}
	
	
	@RequestMapping(value = "/admin/legume/edit")
	public String edit(Model model, Long id) {
		
		Legume legume = legumeRepository.findById(id).get();
		
		model.addAttribute("legume",legume);
		
		return "legume/editLegume";
	}
}
