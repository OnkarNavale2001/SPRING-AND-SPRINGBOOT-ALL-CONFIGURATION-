package com.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.beans.Jobs;
import com.demo.beans.User;
import com.demo.service.Userservice;
import com.demo.service.jobserv;

@Controller
public class Mycontroller {
	@Autowired
	Userservice ser;
	@Autowired
	jobserv jobss;

	@RequestMapping("/aaa")
	public String hellopage() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "------";
	}

	@RequestMapping("/reg")
	public String register() {
		return "register";
	}

	@RequestMapping("/adddata")
	public String registeruserdata(@ModelAttribute("user") User u) {
		
		System.out.println(u.getName());
		boolean b = ser.save(u);
		if (b) {
			return "redirect:/reg";
		} else {
			return "redirect:/reg";
		}

	}

	@RequestMapping("/profile")
	public String profile() {
		return "profile";
	}

	@RequestMapping("/index")
	public String Admin() {
		return "index";
	}

	@RequestMapping("/logindata")
	public String logindata(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		User user = ser.getbyemailandpassword(email, password);
		if (email.equals("admin@gmail.com") && password.equals("admin123")) {
			session.setAttribute("userobj", "Admin");
			return "redirect:/index";
		} else if (user != null) {
			  session.setAttribute("userobj", user);
			return "redirect:/index";
		} else {
			session.setAttribute("mess", "password and email not match");
			return "redirect:/login";
		}
	}

	@RequestMapping("/addjobs")
	public String Addjob() {
		return "addjobs";
	}

	@RequestMapping("/addjob")
	public String addjobs(@ModelAttribute("jobs") Jobs j, HttpSession session) {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String formattedDate = sdf.format(date);
		j.setPdate(formattedDate);
		boolean b = jobss.save(j);
		if (b) {
			session.setAttribute("succ", "Add job successfully");
			return "redirect:/addjobs";
		} else {
			session.setAttribute("succ", "Not success");
			return "redirect:/addjobs";
		}
	}

	@RequestMapping("/viewjobs")
	public String viewjobs(Model m) {
		List<Jobs> job = jobss.getall();
		m.addAttribute("list1", job);
		return "viewjobs";

	}
	@RequestMapping("/delete")
	public String deletejobs(@ModelAttribute("id") Jobs j)
	{
		jobss.delete(j);
		return "redirect:/viewjobs";
	}
	@RequestMapping("/editjobs")
	public String editjobs(@RequestParam("id") int id ,Model m)
	{
	Jobs j=	jobss.findbyid(id);
	m.addAttribute("j", j);
		return "editjob";
	}
	@RequestMapping("/updatejob")
	public String updatejob(@ModelAttribute("j") Jobs j)
	{
		jobss.updatejob(j);
		return "redirect:/viewjobs";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/login";
	}
	@RequestMapping("/viewalljobs")
	public String viewalljobs(Model m) {
		List<Jobs> job = jobss.getall();
		m.addAttribute("list1", job);
		return "viewalljobs";

	}
	@RequestMapping("/viewsinglejob")
	public String viewsinglejobs(@RequestParam("id") int id ,Model m)
	{
	Jobs j=	jobss.findbyid(id);
	m.addAttribute("j", j);
		return "viewsinglejob";
	}
}
