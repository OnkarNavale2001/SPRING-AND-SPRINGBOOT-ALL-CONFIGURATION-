package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.beans.Appointment;
import in.sp.main.repositry.Appointmentrepositry;

@Service
public class Appointmentservice {
	@Autowired
	Appointmentrepositry appoin;

	public boolean savedata(Appointment ap) {
		boolean b = true;
		try {

			appoin.save(ap);
			return b;
		} catch (Exception e) {
			return b = false;
		}
	}

	public List<Appointment> alluser() {
		return appoin.findAll();
	}

	public List<Appointment> alluerbyid(String userid) {
		return appoin.findByidd(userid);
	}

	public List<Appointment> alluser(int doctorid) {
		return appoin.findByid(doctorid);
	}

	public Appointment getbyid(int id) {
		return appoin.findById(id).get();
	}

//	public boolean updatestatus(Appointment a) {
//		boolean b = true;
//		try {
//			appoin.save(a);
//			return b;
//		} catch (Exception e) {
//			return b = false;
//		}
//	}
	
	public boolean updatestatus(int id,String status) {
	boolean b = true;
	try {
		appoin.updatestatus(status,id);
		return b;
	} catch (Exception e) {
		return b = false;
	}
}
}
