package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.beans.Specialist;
import in.sp.main.service.Specalistservice;

@Controller
public class Specialistcontroller {
	@Autowired
	Specalistservice spe;
	@PostMapping("/addspe")
	public String addspecilaist(@ModelAttribute() Specialist s)
	{
		 spe.save(s);
		 return "redirect:/admindash";
	}
}
