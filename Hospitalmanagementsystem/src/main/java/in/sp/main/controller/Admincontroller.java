package in.sp.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.main.beans.Appointment;
import in.sp.main.beans.Specialist;
import in.sp.main.beans.doctor;
import in.sp.main.beans.user;
import in.sp.main.service.Appointmentservice;
import in.sp.main.service.Doctorservice;
import in.sp.main.service.Specalistservice;
import in.sp.main.service.Userservice;
import jakarta.servlet.http.HttpSession;

@Controller
public class Admincontroller {
	@Autowired
	Specalistservice ser;
	@Autowired
	Doctorservice dd;
	@Autowired
	Userservice u;
	@Autowired
	Appointmentservice ss;

	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}

	@GetMapping("/admindash")
	public String admindash(Model m) {
		List<Specialist> lis = ser.getall();
		List<doctor> list = dd.getall();
		List<user> us = u.getall();
		List<Appointment> f = ss.alluser();
		m.addAttribute("spsize", lis.size());
		m.addAttribute("uslist", us.size());
		m.addAttribute("list11", list.size());
		m.addAttribute("applist", f.size());

		return "admindashboard";
	}

	@PostMapping("/adminlog")
	public String adminlog(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		if (email.equals("admin@gmail.com") && password.equals("admin123")) {
			session.setAttribute("adminobj", "Admin");
			return "redirect:/admindash";
		} else {
			session.setAttribute("mess", "Invalid login");
			return "redirect:/adminlogin";
		}
	}

	@GetMapping("/adminlogout")
	public String adminlogout(HttpSession session) {
		session.setAttribute("mess", "logout successfully");
		session.removeAttribute("adminobj");
		return "redirect:/adminlogin";
	}

	@GetMapping("/paitent")
	public String paitent(Model m) {
		List<Appointment> f = ss.alluser();
		Map<Integer, doctor> doctorMap = new HashMap<>();

		for (Appointment appoit : f) {
			doctor d = dd.getbyid(appoit.getDoctorid());
			doctorMap.put(appoit.getDoctorid(), d);
		}

		m.addAttribute("appointments", f);
		m.addAttribute("doctorMap", doctorMap);
		return "paitent";

	}
}
