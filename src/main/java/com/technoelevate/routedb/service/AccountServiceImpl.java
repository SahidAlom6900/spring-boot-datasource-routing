package com.technoelevate.routedb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.technoelevate.routedb.entity.Account;
import com.technoelevate.routedb.repository.AccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }
}
