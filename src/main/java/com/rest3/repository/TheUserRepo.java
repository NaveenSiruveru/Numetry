package com.rest3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest3.model.TheUser;

public interface TheUserRepo extends JpaRepository<TheUser, Integer> {

}
