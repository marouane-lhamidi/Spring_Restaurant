package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Viand;
import com.example.demo.repo.ViandRepository;

@Controller
public class ViandControler {
	@Autowired
	ViandRepository viandRepository; 
	
	@RequestMapping(value = "/admin/viand/index")
	public String index(Model model) {
		List<Viand> viands = viandRepository.findAll();
		
		model.addAttribute("viands",viands);
		
		return "viand/viand";
	}
	
	
	
	@RequestMapping(value = "/admin/viand/save", method=RequestMethod.POST)
	public String save(Model model, Viand v1) {
		Viand viand = viandRepository.findByNom(v1.getNom());
		
		
		if(v1.getId() != null) {
			viandRepository.save(v1);
		}else if(viand != null) {
			viand.setQuntity(v1.getQuntity() + viand.getQuntity());
			viandRepository.save(viand);
		}else {
			viandRepository.save(v1);
		}


		return "redirect:/admin/viand/index";
	}
	
	
	
	@RequestMapping(value = "/admin/viand/delete")
	public String delete(Long id) {
		viandRepository.deleteById(id);
		return "redirect:/viand/index";
	}
	
	
	@RequestMapping(value = "/admin/viand/edit")
	public String edit(Model model, Long id) {
		
		Viand viand = viandRepository.findById(id).get();
		
		model.addAttribute("viand",viand);
		
		return "viand/editViand";
	}
}
