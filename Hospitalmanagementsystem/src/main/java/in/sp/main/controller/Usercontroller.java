package in.sp.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import in.sp.main.beans.Appointment;
import in.sp.main.beans.doctor;
import in.sp.main.beans.user;
import in.sp.main.service.Appointmentservice;
import in.sp.main.service.Doctorservice;
import in.sp.main.service.Userservice;
import jakarta.servlet.http.HttpSession;

@Controller

@SessionAttributes("userd")
public class Usercontroller {
	@Autowired
	Userservice userservice;
	@Autowired
	Doctorservice dd;
	@Autowired
	Appointmentservice ss;

	@GetMapping("/index")
	public String view() {
		return "index";
	}

	@GetMapping("/signup")
	public String Signup() {
		return "signup";
	}

	@PostMapping("/add")
	public String registration(@ModelAttribute() user u, HttpSession session) {
		if (userservice.save(u)) {
			session.setAttribute("mssg", "Register successfully");
			return "redirect:/signup";
		} else {
			session.setAttribute("mssg", "Something Went wrong");
			return "redirect:/signup";

		}

	}

	@GetMapping("/userlogin")
	public String userloginform() {
		return "userlogin";
	}

	@GetMapping("/app")
	public String appointment(Model m) {
		List<doctor> d = dd.getall();
		m.addAttribute("doctorList", d);
		return "app";
	}

	@PostMapping("/userlogg")
	public String userlog(@RequestParam("email") String email, @RequestParam("password") String password,
	        HttpSession session, Model m) {
	    user u = userservice.getuser(email, password);
	    if (u != null && email.equals(u.getEmail()) && password.equals(u.getPassword())) {
	        session.setAttribute("userobj", u);
	        m.addAttribute("userd", u);
	        return "redirect:/app";
	    } else {
	        session.setAttribute("mess", "Invalid");
	        return "redirect:/userlogin";
	    }
	}

	@GetMapping("/viewapp")
	public String viewappp(Model m, HttpSession session) {
	    user user = (user) session.getAttribute("userd");
	    String idd = String.valueOf(user.getId());
	    List<Appointment> f = ss.alluerbyid(idd);
	    Map<Integer, doctor> doctorMap = new HashMap<>();

	    for (Appointment appoit : f) {
	        doctor d = dd.getbyid(appoit.getDoctorid());
	        doctorMap.put(appoit.getDoctorid(), d);
	    }
	    m.addAttribute("appointments", f);
	    m.addAttribute("doctorMap", doctorMap);
	    return "viewappointments";
	}
	@GetMapping("/userlogout")
	public String userlogout(HttpSession session)
	{
		session.setAttribute("mess", "logout successfully");
		session.removeAttribute("userobj");
	
		return "redirect:/userlogin";
	}
}
