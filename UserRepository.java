package com.example.demo.Repository;


import com.example.demo.model.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface UserRepository extends JpaRepository<User,Integer>{

  }

