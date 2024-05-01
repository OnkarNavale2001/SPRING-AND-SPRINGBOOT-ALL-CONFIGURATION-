package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.beans.doctor;
import in.sp.main.repositry.Doctorrepositry;

@Service
public class Doctorservice {
	@Autowired
	Doctorrepositry doc;

	public boolean adddoctor(doctor d) {
		boolean b = true;
		try {
			doc.save(d);
			return b;
		} catch (Exception e) {
			return b = false;
		}
	}

	public List<doctor> getall() {
		return doc.findAll();
	}

	public boolean deletebyid(doctor d) {
		boolean b = true;
		try {
			doc.delete(d);
			return b;
		} catch (Exception e) {
			return b = false;
		}
	}
	public doctor getbyid(int id)
	{
		return doc.findById(id).get();
	}
	public boolean updatedoctor(doctor d) {
		boolean b = true;
		try {
			doc.save(d);
			return b;
		} catch (Exception e) {
			return b = false;
		}
	}
	public doctor getuser(String email,String password)
	{
		return doc.findByEmailAndPassword(email, password);
		
	}

}
