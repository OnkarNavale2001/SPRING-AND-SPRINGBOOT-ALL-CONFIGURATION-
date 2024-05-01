package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Jobs;
import com.demo.repositry.Jobsrepo;

@Service
public class jobserv {
	@Autowired
	Jobsrepo repo;
	public boolean save(Jobs u) {
		boolean b = false;
		try {
			repo.save(u);
			return b = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return b;
		}

	}
	public List<Jobs> getall()
	{
		return repo.findAll();
	}
	public void delete(Jobs j)
	{
		repo.delete(j);
	}
	public Jobs findbyid(int id)
	{
        return repo.findById(id).get();
	}
     public void updatejob(Jobs j)
     {
    	 repo.save(j);
     }
}
