package com.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.beans.Recipedetails;
import com.demo.services.MyServies;

@Controller
public class MyController {
	@Autowired
	MyServies services;

	@RequestMapping("/index")
	public String index(Model m)

	{
		List<Recipedetails> recipe = services.getallrecipe();
		m.addAttribute("model", recipe);

		return "index";
	}

	@RequestMapping("/submit")
	public String getdata(@ModelAttribute Recipedetails recipe)

	{

		services.insertdata(recipe);

		return "redirect:/index";

	}

	@GetMapping("/deletedata")
	public String deletedata(@ModelAttribute Recipedetails recipe) {
		services.deletedata(recipe);
		return "redirect:/index";
	}

	@RequestMapping("/update")
	public String getrecipebyid(@ModelAttribute Recipedetails recipe) {
	services.Updaterecipe(recipe);

		return "redirect:/index";
	}

}
