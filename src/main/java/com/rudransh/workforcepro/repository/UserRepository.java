package com.rudransh.workforcepro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudransh.workforcepro.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}