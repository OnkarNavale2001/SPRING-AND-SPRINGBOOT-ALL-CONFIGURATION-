package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.Dao;
import com.demo.beans.Student;

import antlr.collections.List;

@Service
public class Serviceclas {
	@Autowired
	private Dao dao;
	
	
	public void insert(Student s)
	{
		dao.insertdata(s);
	}
	public java.util.List<Student> getall()
	{
		return dao.getallstudent();
	}
	public void delete(Student s)
	{
		    dao.delete(s);
	}
	public void update(Student s) {
	  dao.update(s);
		
	}

}
