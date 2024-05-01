package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Recipedetails;
import com.demo.repositry.MyRepositry;

@Service
public class MyServies {
	@Autowired
	private MyRepositry repo;

	public void insertdata(Recipedetails recipe) {
		repo.insertdata(recipe);
	}

	public List<Recipedetails> getallrecipe() {
		return repo.getallrecipe();
	}

	public void deletedata(Recipedetails recipe) {
		repo.deletedata(recipe);

	}

	public void Updaterecipe(Recipedetails recipe) {
	repo.update(recipe);

	}

}
