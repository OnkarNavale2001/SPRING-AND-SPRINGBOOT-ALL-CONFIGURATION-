package com.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Jobs;
@Repository
public interface Jobsrepo extends JpaRepository<Jobs, Integer>{
	public Jobs save(Jobs j);
//	public List<Jobs> findAll();

}
