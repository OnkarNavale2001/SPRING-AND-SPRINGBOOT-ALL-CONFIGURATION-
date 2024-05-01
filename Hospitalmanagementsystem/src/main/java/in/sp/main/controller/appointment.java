package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.beans.Appointment;
import in.sp.main.service.Appointmentservice;
import jakarta.servlet.http.HttpSession;

@Controller
public class appointment {
	@Autowired
	Appointmentservice ser;
	@PostMapping("/addapoint")
  public String addapoint(@ModelAttribute() Appointment a,HttpSession session)
  {
		a.setStatus("Pending");
	  if(ser.savedata(a))
	  {
		 session.setAttribute("mess", "Data added successfully");
		 return "redirect:/app";
	  }
	  else {
		  session.setAttribute("mess", "Data not added ");
			 return "redirect:/app";
	}
  }

}
