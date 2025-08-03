package com.vinu.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinu.demoapp.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
