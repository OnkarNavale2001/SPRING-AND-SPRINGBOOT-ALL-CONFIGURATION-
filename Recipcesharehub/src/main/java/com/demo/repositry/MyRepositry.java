package com.demo.repositry;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Recipedetails;

@Repository
public class MyRepositry {
	@Autowired
	private HibernateTemplate template;

	@javax.transaction.Transactional
	public void insertdata(Recipedetails recipe) {
		template.save(recipe);
	}

	@Transactional
	public List<Recipedetails> getallrecipe() {
		return template.loadAll(Recipedetails.class);
	}

	@Transactional
	public void deletedata(Recipedetails recipe) {
		template.delete(recipe);

	}

	@Transactional
	public void update(Recipedetails recipe) {
		Recipedetails details = template.load(Recipedetails.class, recipe.getId());
		details.setImage(recipe.getImage());
		details.setDescription(recipe.getDescription());
		details.setTitle(recipe.getTitle());
		details.setType(recipe.getType());
	     template.update(details);

	}
}
