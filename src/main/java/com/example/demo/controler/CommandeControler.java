package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.entities.Commande;
import com.example.demo.entities.Plat;
import com.example.demo.entities.Boisson;
import com.example.demo.entities.Viand;
import com.example.demo.entities.Fruit;
import com.example.demo.entities.Legume;
import com.example.demo.repo.CommandeRepository;
import com.example.demo.repo.FruitRepository;
import com.example.demo.repo.LegumeRepository;
import com.example.demo.repo.PlatRepository;
import com.example.demo.repo.ViandRepository;
import com.example.demo.repo.BoissonRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin/")
public class CommandeControler {
	@Autowired
	CommandeRepository commandeRepository; 
	@Autowired
	BoissonRepository boissonRepository; 
	@Autowired
	PlatRepository platRepository; 
	@Autowired
	ViandRepository viandRepository; 
	@Autowired
	FruitRepository fruitRepository; 
	@Autowired
	LegumeRepository legumeRepository; 
	
	
	@RequestMapping(value = "/commande/index")
	public String index(Model model) {
		List<Plat> plats = platRepository.findAll();
		List<Boisson> boissons = boissonRepository.findAll();
		List<Commande> commandes = commandeRepository.findAll();
		
		
		model.addAttribute("plats",plats);
		model.addAttribute("boissons",boissons);
		model.addAttribute("commandes",commandes);

		
		return "commande/commande";
	}
	
	
	
	@RequestMapping(value = "/commande/save", method=RequestMethod.POST)
	public String save(Model model, Commande c1) {
		Plat plat = platRepository.findById(c1.getIdPlat()).get();
		Boisson boisson = boissonRepository.findById(c1.getIdBoisson()).get();
		Fruit fruit = fruitRepository.findById(plat.getIdFruit()).get();
		Legume legume = legumeRepository.findById(plat.getIdLegume()).get();
		Viand viand = viandRepository.findById(plat.getIdViand()).get();
		
		
		
		if (boisson.getQuntity() < c1.getQuantityBoisson())
        {
			model.addAttribute("Error","You don't have enough Soda");
        }
        else if (fruit.getQuntity() < plat.getQuantityFruit())
        {
        	model.addAttribute("Error","You don't have enough Fruit");
        }
        else if (viand.getQuntity() < plat.getQuantityViad())
        {
        	model.addAttribute("Error","You don't have enough Viand");
        }
        else if (legume.getQuntity() < plat.getQuantityLegume())
        {
        	model.addAttribute("Error","You don't have enough Legume");
        }
        else 
        {
        	boisson.setQuntity(boisson.getQuntity() - c1.getQuantityBoisson() );
    		fruit.setQuntity(fruit.getQuntity() - plat.getQuantityFruit());
    		legume.setQuntity(legume.getQuntity() - plat.getQuantityLegume());
    		viand.setQuntity(viand.getQuntity() - plat.getQuantityViad());
    		
    		commandeRepository.save(c1);
        }
		

	
		


		return "redirect:index";
	}
	
	
	
	@RequestMapping(value = "/commande/delete")
	public String delete(Long id) {
		Commande commande = commandeRepository.findById(id).get();
		Plat plat = platRepository.findById(commande.getIdPlat()).get();
		Boisson boisson = boissonRepository.findById(commande.getIdBoisson()).get();
		Fruit fruit = fruitRepository.findById(plat.getIdFruit()).get();
		Legume legume = legumeRepository.findById(plat.getIdLegume()).get();
		Viand viand = viandRepository.findById(plat.getIdViand()).get();
		
		boisson.setQuntity(boisson.getQuntity() + commande.getQuantityBoisson() );
		fruit.setQuntity(fruit.getQuntity() + plat.getQuantityFruit());
		legume.setQuntity(legume.getQuntity() + plat.getQuantityLegume());
		viand.setQuntity(viand.getQuntity() + plat.getQuantityViad());
		
		commandeRepository.deleteById(id);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/commande/isReady")
	public String isReady(@RequestParam Long id) {
		Commande commande = commandeRepository.findById(id).get();
		commande.setReady(true);
		commandeRepository.save(commande);

		return "redirect:index";
	}
	
	
	
	
	
}
