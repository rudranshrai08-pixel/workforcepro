package com.rudransh.workforcepro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}