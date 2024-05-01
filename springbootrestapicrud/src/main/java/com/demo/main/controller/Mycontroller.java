package com.demo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.main.Repositry.Userrepositry;
import com.demo.main.beans.User;
import com.demo.main.service.Userservice;

@RestController
public class Mycontroller {
	@Autowired
	Userservice ser;

   @PostMapping("/employee")
	public User adddata(@RequestBody User u)
	{
	   System.out.println(u);
		User user=ser.adddata(u);
		return user;
}
   @GetMapping("/employee")
   public List<User> getall()
   {
	   List<User> list=ser.getall();
	   return list;
   }
   
   @GetMapping("/employee/{id}")
  public User getstudentbyid(@PathVariable("id") int id)
  {
	    return ser.getbyid(id);
  }
	@DeleteMapping("/employee/{id}")
   public boolean deleteuser(@PathVariable("id") int id)
   {
	     return ser.deletebyid(id);
   }
  
	 @PutMapping("/employee")
		public User update(@RequestBody User u)
		{
			User user=ser.adddata(u);
			return user;
	}
	
	
}
