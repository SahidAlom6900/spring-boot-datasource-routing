package com.technoelevate.routedb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.technoelevate.routedb.e_constants.DataSourceType;
import com.technoelevate.routedb.entity.User;
import com.technoelevate.routedb.repository.UserRepository;
import com.technoelevate.routedb.util.WithDatabase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @WithDatabase
    public List<User> findAllDS1() {
        return this.findAll();
    }

    @Override
    @WithDatabase(DataSourceType.SECONDARY)
    public List<User> findAllDS2() {
        return this.findAll();
    }

    @Override
    @WithDatabase(DataSourceType.TERTIARY)
    public List<User> findAllDS3() {
        return this.findAll();
    }

    @Override
    public Page<User> findAllDS1(Pageable pageable) {
        return this.findAll(pageable);
    }

    @Override
    @WithDatabase(DataSourceType.SECONDARY)
    public Page<User> findAllDS2(Pageable pageable) {
        return this.findAll(pageable);
    }

    @Override
    @WithDatabase(DataSourceType.TERTIARY)
    public Page<User> findAllDS3(Pageable pageable) {
        return this.findAll(pageable);
    }

    private List<User> findAll() {
        return this.userRepository.findAll();
    }

    private Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }
}
