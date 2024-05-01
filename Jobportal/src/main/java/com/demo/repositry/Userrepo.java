package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;
@Repository
public interface Userrepo extends JpaRepository<User,Integer> {
public User save(User u);
public User findByEmailAndPassword(String email, String password);
	
	
}
