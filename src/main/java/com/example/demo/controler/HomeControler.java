package com.example.demo.controler;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Fruit;

@Controller
public class HomeControler {

	@RequestMapping(value = "/")
	public String index(Model model) {
		
		
		return "home";
	}
	
}
