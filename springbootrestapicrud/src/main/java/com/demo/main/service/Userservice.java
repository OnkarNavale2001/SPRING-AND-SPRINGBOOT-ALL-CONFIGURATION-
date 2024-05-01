package com.demo.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.main.Repositry.Userrepositry;
import com.demo.main.beans.User;

@Service
public class Userservice {
	@Autowired
	Userrepositry userr;

	public User adddata(User u) {
		return userr.save(u);
	}

	public List<User> getall() {
		// TODO Auto-generated method stub
		return userr.findAll();
	}

	public User getbyid(int id) {
		return userr.findById(id).get();
	}

	public boolean deletebyid(int id) {
		boolean b = true;
		try {
			userr.deleteById(id);
			return b;
		} catch (Exception e) {
			// TODO: handle exception
			return b = false;

		}

	}
	

}
