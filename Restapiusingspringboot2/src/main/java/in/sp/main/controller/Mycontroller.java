package in.sp.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
	@GetMapping("/")
	public String viewdata()
	{
		return "hello onkar";
	}
	@PostMapping("/")
	public String view(@RequestParam("name")String name,@RequestParam("email")String email)
	{
		return name+email;
	}

}
