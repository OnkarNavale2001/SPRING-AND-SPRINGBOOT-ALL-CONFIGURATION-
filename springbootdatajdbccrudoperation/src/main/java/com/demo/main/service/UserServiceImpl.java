package com.demo.main.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.main.repositry.UserDao ;

import com.demo.main.beans.User;


@Service
public class UserServiceImpl {
	@Autowired
	UserDao userDao;

	@Transactional

	public boolean addUser(User user) {
		boolean status = false;

		try {
			User.is_new = true;
			User user1 = userDao.save(user);
			if (user1.getEmail().equals(user.getId())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	@Transactional

	public boolean updateUser(User user) {
		boolean status = false;

		try {
			User.is_new = false;
			User user1 = userDao.save(user);
			if (user1.getEmail().equals(user.getId())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	@Transactional

	public boolean deleteUser(String email) {
		boolean status = false;

		try {
			userDao.deleteById(email);
			status = true;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	public User searchUser(String email) {
		User user = null;

		try {
			Optional<User> optional = userDao.findById(email);
			if (optional.isPresent()) {
				user = optional.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Transactional
	public List<User> getAllUsers() {
		Iterable<User> iterable = userDao.findAll();

		List<User> list_users = new ArrayList<>();

		Iterator<User> itr = iterable.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			list_users.add(user);
		}

		return list_users;
	}
}
