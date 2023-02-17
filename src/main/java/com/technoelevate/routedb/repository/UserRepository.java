package com.technoelevate.routedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoelevate.routedb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
