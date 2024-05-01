package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import in.sp.main.beans.Appointment;
import in.sp.main.beans.Specialist;
import in.sp.main.beans.doctor;

import in.sp.main.service.Appointmentservice;
import in.sp.main.service.Doctorservice;
import in.sp.main.service.Specalistservice;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("docd")
public class Doctorcontroller {
	@Autowired
	Specalistservice ser;
	@Autowired
	Doctorservice dd;
	@Autowired
   Appointmentservice see;
	@GetMapping("/doctorlogin")
	public String doctorlogin() {
		return "doctorlogin";
	}

	@GetMapping("/adddoctor")
	public String adddoctor(Model m) {
		List<Specialist> lis = ser.getall();
		m.addAttribute("list", lis);

		return "adddoctor";
	}

	@PostMapping("/adddoc")
	public String adddoc(@ModelAttribute() doctor d, HttpSession session) {
		if (dd.adddoctor(d)) {
			session.setAttribute("succ", "Doctor Added Successfully");
			return "redirect:/adddoctor";
		} else {
			session.setAttribute("succ", "Some thing went wrong");
			return "redirect:/adddoctor";
		}
	}

	@GetMapping("/alldoctor")
	public String viewdoctor(Model m) {
		List<doctor> list = dd.getall();
		m.addAttribute("list11", list);
		return "alldoctor";
	}

	@GetMapping("/deletedoctor")
	public String delete(@RequestParam("id") String id, HttpSession session) {
		doctor d = new doctor();
		d.setId(Integer.parseInt(id));
		if (dd.deletebyid(d)) {
			session.setAttribute("succ", "Doctor Deleted Successfully");
			return "redirect:/alldoctor";
		} else {
			session.setAttribute("succ", "Some thing went wrong");
			return "redirect:/alldoctor";
		}

	}

	@GetMapping("/editdoctor")
	public String editdoctor(@RequestParam("id") int id, Model m) {
		List<Specialist> lis = ser.getall();
		doctor d = dd.getbyid(id);
		m.addAttribute("list", lis);
		m.addAttribute("d", d);
		return "editdoctor";
	}

	@PostMapping("/updatedoctor")
	public String updatedoctor(@ModelAttribute() doctor d, HttpSession session) {
		if (dd.updatedoctor(d)) {
			session.setAttribute("succ", "Doctor Updated Successfully");
			return "redirect:/alldoctor";
		} else {
			session.setAttribute("succ", "Some thing went wrong");
			return "redirect:/alldoctor";
		}

	}

	@GetMapping("/doctorhome")
	public String doctorho() {
		return "doctorhome";
	}

	@PostMapping("/doctorlog")
	public String doctorLog(@RequestParam("email") String email, @RequestParam("password") String password,
	        HttpSession session, Model model) {
	    doctor d = dd.getuser(email, password);
	    if (d != null && email.equals(d.getEmail()) && password.equals(d.getPassword())) {
	    	session.setAttribute("doctor", d);
	    	  model.addAttribute("docd", d);
	      
	        return "redirect:/doctorhome";
	    } else {
	        model.addAttribute("mess", "Invalid");
	        return "doctorlogin"; // Forward to the login page to display the error message
	    }
	}
	 
     @GetMapping("/doctorappointment")
	public String viewappp(Model m, HttpSession session) {
	   doctor user = (doctor) session.getAttribute("docd");
	  
	    List<Appointment> f = see.alluser(user.getId());

	    
	    m.addAttribute("appointments", f);
	    return "doctorappointment";
	}
     
     @GetMapping("/comment")
     public String comment(@RequestParam("id") int id,Model m)
     {
    	 System.out.println(id);
    	 Appointment ap=see.getbyid(id);

    	 m.addAttribute("ap", ap);
    	 return "comment";
     }
//     @PostMapping("/comm")
//     public String updatecomment(@ModelAttribute("u") Appointment a)
//     {
//    	
//    	 if(see.updatestatus(a))
//    	 {
//    		return "redirect:/doctorappointment"; 
//    	 }
//    	 else {
//    		 return "redirect:/doctorappointment"; 
//		}
//     }
//     
     @PostMapping("/comm")
     public String updatecomment(@RequestParam("id")int id,@RequestParam("status") String status)
     {
    	  System.out.println(id);
    	  System.out.println(status);
    	 if(see.updatestatus(id, status))
    	 {
    		 System.out.println("updates");
    		return "redirect:/doctorappointment"; 
    	 }
    	 else {
    		 System.out.println("not updates");
    		 return "redirect:/doctorappointment"; 
		}
     }
     
     
     @GetMapping("/doclogout")
	 	public String userlogout(HttpSession session,SessionStatus status)
	 	{
    	 session.setAttribute("mess", "logout successfully");
		session.removeAttribute("doctor");
	 	    return "redirect:/doctorlogin";
	 	}
}
