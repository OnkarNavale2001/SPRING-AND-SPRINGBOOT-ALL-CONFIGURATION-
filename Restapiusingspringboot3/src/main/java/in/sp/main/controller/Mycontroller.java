package in.sp.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
  
	@GetMapping("/hello/{name}/{email}")
	public String hello(@PathVariable("name")String name,@PathVariable("email")String email)
	{
	     return name+email;	
	}
	@PostMapping("/hello/{name}/{email}")
	public String hello1(@PathVariable("name")String name,@PathVariable("email")String email)
	{
	     return name+email;	
	}
}
