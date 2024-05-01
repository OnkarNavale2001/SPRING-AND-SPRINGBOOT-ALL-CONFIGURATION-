package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.beans.user;
import in.sp.main.repositry.Userrepositry;

@Service
public class Userservice {
	@Autowired
	Userrepositry repo;
	public boolean save(user u)
	{
		boolean b=true;
		try {
			repo.save(u);
			return b;
		} catch (Exception e) {
			return b=false;
		}
	
	}
	public user getuser(String email,String password)
	{
		return repo.findByEmailAndPassword(email, password);
		
	}
	public List<user> getall()
	{
		return repo.findAll();
	}
}
