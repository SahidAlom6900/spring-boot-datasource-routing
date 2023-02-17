package com.technoelevate.routedb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.technoelevate.routedb.e_constants.DataSourceType;
import com.technoelevate.routedb.entity.Test;
import com.technoelevate.routedb.repository.TestRepository;
import com.technoelevate.routedb.util.WithDatabase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

	private final TestRepository testRepository;

	@Override
	@WithDatabase(DataSourceType.SECONDARY)
	public List<Test> findAllDS1() {
		return this.testRepository.findAll();
	}

	@Override
	@WithDatabase(DataSourceType.PRIMARY)
	public List<Test> findAllDS2() {
		return this.testRepository.findAll();
	}

}
