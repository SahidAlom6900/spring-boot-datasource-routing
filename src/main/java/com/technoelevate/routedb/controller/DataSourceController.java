package com.technoelevate.routedb.controller;

import java.time.LocalDate;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.routedb.service.AccountService;
import com.technoelevate.routedb.service.TestService;
import com.technoelevate.routedb.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/db")
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DataSourceController {

	private final AccountService accountService;

	private final TestService testService;

	private final UserService userService;

	@GetMapping
	public void name() {
		System.out.println(this.userService.findAllDS1());
		System.out.println(this.userService.findAllDS2());
		System.out.println(this.userService.findAllDS3());
		System.out.println(this.testService.findAllDS1());
		System.out.println(this.testService.findAllDS2());
	}

//	package com.technoelevate.routedb;
//	
//	import com.technoelevate.routedb.repository.AccountRepository;
//	import com.technoelevate.routedb.service.AccountService;
//	import com.technoelevate.routedb.service.TestService;
//	import com.technoelevate.routedb.service.UserService;
//	import com.technoelevate.routedb.util.WithDatabase;
//	
//	import lombok.RequiredArgsConstructor;
//	import org.springframework.boot.context.event.ApplicationReadyEvent;
//	import org.springframework.context.event.EventListener;
//	import org.springframework.data.domain.PageRequest;
//	import org.springframework.stereotype.Component;
//	
//	@Component
//	@RequiredArgsConstructor
//	public class Startup {
//	
//	    private final UserService userService;
//	
//	    private final AccountService accountService;
//	
//	    private final AccountRepository accountRepository;
//	    
//	    private final TestService testService;
//	
//	    @EventListener(ApplicationReadyEvent.class)
//	    public void startUp() {
//	        System.out.println("App Started!");
//	        this.testAnnotatedMethods();
//	        this.testRoutedRepository();
//	        this.testDialectByUsingPagination();
//	
//	        System.exit(0);
//	    }
//	
//	    /**
//	     * Tests different methods annotated with {@link WithDatabase} annotation.
//	     * Look at the printed results and see if they are the same as the values in the corresponding database.
//	     */
//	    private void testAnnotatedMethods() {
//	        System.out.println("TEST Annotated Methods");
//	        System.out.println(this.userService.findAllDS1());
//	        System.out.println(this.userService.findAllDS2());
//	        System.out.println(this.userService.findAllDS3());
//	        System.out.println(this.testService.findAllDS1());
//	        System.out.println(this.testService.findAllDS2());
//	
//	    }
//	
//	    /**
//	     * Only the MS SQL Server database has the account table, so it this code executes successfully, it means
//	     * that the TERTIARY datasource was used.
//	     */
//	    private void testRoutedRepository() {
//	        System.out.println("TEST Routed Repository");
//	        System.out.println(this.accountService.findAll());
//	        System.out.println(this.accountRepository.findAll());
//	    }
//	
//	    /**
//	     * MS SQL Server uses top and MySQL uses LIMIT to achieve pagination.
//	     * If the dialect is working properly, the corresponding queries should have these keywords.
//	     * If it is not working correctly, there will be a syntax error and this code will fail to execute.
//	     */
//	    private void testDialectByUsingPagination() {
//	        System.out.println("TEST Dialects");
//	        this.userService.findAllDS1(PageRequest.of(0, 5));
//	        this.userService.findAllDS2(PageRequest.of(0, 5));
//	        this.userService.findAllDS3(PageRequest.of(0, 5));
//	    }
//	}

}
