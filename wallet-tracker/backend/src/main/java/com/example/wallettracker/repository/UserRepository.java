package com.example.wallettracker.repository;

import com.example.wallettracker.model.User;

import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Long> {
}
