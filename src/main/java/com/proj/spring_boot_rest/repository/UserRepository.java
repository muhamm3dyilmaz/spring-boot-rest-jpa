package com.proj.spring_boot_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.spring_boot_rest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
