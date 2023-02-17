package com.technoelevate.routedb.config;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.technoelevate.routedb.e_constants.DataSourceType;
import com.technoelevate.routedb.repository.AccountRepository;
import com.technoelevate.routedb.repository.TestRepository;
import com.technoelevate.routedb.util.DatabaseContextHolder;
import com.technoelevate.routedb.util.TransactionalHelper;
import com.technoelevate.routedb.util.WithDatabase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RoutingRepositoryConfig {

	private final AccountRepository accountRepository;

	private final TestRepository testRepository;

	private final TransactionalHelper transactionalHelper;

	public RoutingRepositoryConfig(@Qualifier("accountRepositoryNonConfig") AccountRepository accountRepository,
			TransactionalHelper transactionalHelper,
			@Qualifier("testRepositoryNonConfig") TestRepository testRepository) {
		this.accountRepository = accountRepository;
		this.transactionalHelper = transactionalHelper;
		this.testRepository = testRepository;
	}

	@Bean
	@Primary
	public AccountRepository accountRepository() {
		return this.createProxyInstance(this.accountRepository);
	}

	@Bean
	public TestRepository testRepository() {
		return this.createProxyInstance(this.testRepository);
	}

	private <E, ID, T extends JpaRepository<E, ID>> T createProxyInstance(T repository) {
		final Class<?> repositoryType = repository.getClass().getInterfaces()[0];
		final DataSourceType dataSourceType = repositoryType.getAnnotation(WithDatabase.class).value();

		Object instance = null;
		try {
			instance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
					new Class[] { repositoryType }, (proxy, method, args) -> {
						DatabaseContextHolder.setCtx(dataSourceType);
						try {
							return this.transactionalHelper.runWithTransaction(() -> method.invoke(repository, args));
						} finally {
							DatabaseContextHolder.restoreCtx();
						}
					});
		} catch (Exception ex) {
			log.error("Error while creating proxy for class {}", repository, ex);
			throw new RuntimeException(ex);
		}

		return (T) instance;
	}
}
