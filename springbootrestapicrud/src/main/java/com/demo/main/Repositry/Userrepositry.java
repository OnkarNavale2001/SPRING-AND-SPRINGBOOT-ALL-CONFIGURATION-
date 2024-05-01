package com.demo.main.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.main.beans.User;
@Repository
public interface Userrepositry extends JpaRepository<User, Integer> {

}
