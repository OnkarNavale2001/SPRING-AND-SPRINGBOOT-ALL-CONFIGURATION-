package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.beans.Specialist;
import in.sp.main.repositry.Specailistrepositry;

@Service
public class Specalistservice {
	@Autowired
	Specailistrepositry spe;

	public void save(Specialist s) {
		spe.save(s);
	}
	public List<Specialist> getall()
	{
		return spe.findAll();
	}

}
