package com.example.demo.controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Fruit;
import com.example.demo.entities.Legume;
import com.example.demo.entities.Plat;
import com.example.demo.entities.Viand;
import com.example.demo.repo.PlatRepository;
import com.example.demo.repo.ViandRepository;
import com.example.demo.repo.FruitRepository;
import com.example.demo.repo.LegumeRepository;

@Controller
public class PlatControler {
	@Autowired
	PlatRepository platRepository; 
	@Autowired
	ViandRepository viandRepository; 
	@Autowired
	FruitRepository fruitRepository; 
	@Autowired
	LegumeRepository legumeRepository; 
	
	@RequestMapping(value = "/admin/plat/index")
	public String index(Model model) {
		List<Plat> plats = platRepository.findAll();
		List<Fruit> fruits = fruitRepository.findAll();
		List<Legume> legumes = legumeRepository.findAll();
		List<Viand> viands = viandRepository.findAll();
		
		
		
		model.addAttribute("plats",plats);
		model.addAttribute("fruits",fruits);
		model.addAttribute("legumes",legumes);
		model.addAttribute("viands",viands);
		
		return "plat/plat";
	}
	
	
	
	@RequestMapping(value = "/admin/plat/save", method=RequestMethod.POST)
	public String save(Model model, Plat p1, @RequestParam("img") MultipartFile image) {
		
/*		
		if(b1.getId() != null) {
			platRepository.save(b1);
		}else {
			platRepository.save(b1);
		}
*/
		
		String nomimage=image.getOriginalFilename().split("\\.")[0];
		String imageExtension=image.getOriginalFilename().split("\\.")[1];
		try {   
			image.transferTo(new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString()+"\\src\\main\\resources\\static\\UploadedImages\\"+nomimage+"."+imageExtension));
		    p1.setImage("/UploadedImages/"+nomimage+"."+imageExtension);
			platRepository.save(p1);

		    
		} 
		catch (IllegalStateException e) {} 
		catch (IOException e) {}
		

		return "redirect:index";
	}
	
	
	
	@RequestMapping(value = "/admin/plat/delete")
	public String delete(Long id) {
		platRepository.deleteById(id);
		return "redirect:index";
	}
	
	
	@RequestMapping(value = "/admin/plat/edit")
	public String edit(Model model, Long id) {
		
		Plat plat = platRepository.findById(id).get();
		
		model.addAttribute("plat",plat);
		
		return "plat/editPlat";
	}
}
