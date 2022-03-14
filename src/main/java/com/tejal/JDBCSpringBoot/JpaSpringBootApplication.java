package com.tejal.JDBCSpringBoot;

import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tejal.JDBCSpringBoot.database.entity.Person;
import com.tejal.JDBCSpringBoot.database.jdbc.PersonJdbcDao;
import com.tejal.JDBCSpringBoot.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("user id 1001 -> {}",repository.findById(1001));
		logger.info("Inserting 1004 -> No of Rows Inserted - {}",repository.insert(new Person(1004, "Tara", "Berlin",new Date())));
		logger.info("Updating 1003 -> {}",repository.update(new Person(1003, "Pieter", "Utrecht", new Date())));
		repository.deleteById(1002);
		logger.info("All users -> {}",repository.findAll() );	
		
	}

}
