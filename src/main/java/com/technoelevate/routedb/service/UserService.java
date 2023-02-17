package com.technoelevate.routedb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.technoelevate.routedb.entity.User;

public interface UserService {

    List<User> findAllDS1();

    List<User> findAllDS2();

    List<User> findAllDS3();

    Page<User> findAllDS1(Pageable pageable);

    Page<User> findAllDS2(Pageable pageable);

    Page<User> findAllDS3(Pageable pageable);
}
