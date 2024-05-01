package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Jobs;
import com.demo.beans.User;
import com.demo.repositry.Userrepo;

@Service
public class Userservice {
	@Autowired
	Userrepo user;

	public boolean save(User u) {
		boolean b = false;
		try {
			user.save(u);
			return b = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return b;
		}

	}
	
	public User getbyemailandpassword(String email,String password)
	{
		return user.findByEmailAndPassword(email, password);
	}

}
