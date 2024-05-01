package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.main.beans.Student;
import in.sp.main.service.Studentservice;
import jakarta.servlet.http.HttpSession;

@Controller
public class Mycontroller {
	@Autowired
	Studentservice ser;

	@GetMapping("/index")
	public String indexpage(Model m) {
		List<Student> s = ser.getall();
		m.addAttribute("list", s);
		return "index";
	}

	@PostMapping("/send")
	public String senddata(@ModelAttribute("s") Student s, HttpSession session, Model m) {
		int i = ser.senddata(s);
		System.out.println(s.getEmail());
		if (i > 0) {

			return "redirect:/index";
		} else {
			return "redirect:/index";
		}

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		Student s = new Student();
		s.setId(id);
		int i = ser.delete(s);
		return "redirect:/index";
	}

	@GetMapping("/edit")
	public String updat(@RequestParam("id") int id, Model m) {
		Student s = new Student();
		s.setId(id);
		List<Student> list = ser.getyid(id);
		for (Student student : list) {
			Student st = new Student();
			st.setEmail(student.getEmail());
			st.setId(student.getId());
			st.setName(student.getName());
			st.setPassword(student.getPassword());
			m.addAttribute("s", st);

		}
		return "update";
	}

	@PostMapping("/updatedata")
	public String update(@ModelAttribute("s") Student s, HttpSession session, Model m) {
		int i = ser.update(s);
		System.out.println(s.getEmail());
		if (i > 0) {

			return "redirect:/index";
		} else {
			return "redirect:/index";
		}

	}

}
