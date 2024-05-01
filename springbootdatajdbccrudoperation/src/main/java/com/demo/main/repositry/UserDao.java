package com.demo.main.repositry;

import org.springframework.data.repository.CrudRepository;

import com.demo.main.beans.User;

public interface UserDao extends CrudRepository<User, String>
{
	
}