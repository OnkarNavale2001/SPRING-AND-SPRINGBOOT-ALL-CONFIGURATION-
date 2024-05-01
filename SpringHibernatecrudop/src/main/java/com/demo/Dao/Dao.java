package com.demo.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Student;

@Repository

public class Dao {
	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void insertdata(Student s) {
		template.save(s);
	}

	@Transactional

	public List<Student> getallstudent() {
		return template.loadAll(Student.class);
	}

	@Transactional

	public void delete(Student s) {
		template.delete(s);
	}

	@Transactional
	public void update(Student s) {
		Student st = template.load(Student.class, s.getId());
		
		st.setEmail(s.getEmail());
		st.setName(s.getName());
		st.setPhone(s.getPhone());
	template.update(st);

	}

}
