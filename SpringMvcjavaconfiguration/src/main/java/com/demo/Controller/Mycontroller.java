package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mycontroller {
@RequestMapping("/aaa")
	public String openhello()
	{
		return "index";
	}
	
	
}
