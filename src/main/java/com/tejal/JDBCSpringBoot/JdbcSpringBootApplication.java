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

@SpringBootApplication
public class JdbcSpringBootApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}",dao.findAll() );	
		logger.info("user id 1001 -> {}",dao.findById(1001));
		logger.info("Deleting 1002 -> No of Rows Deleted - {}",dao.deleteById(1002));
		logger.info("Inserting 1004 -> No of Rows Inserted - {}",dao.insert(new Person(1004, "Tara", "Berlin",new Date())));
		logger.info("Updating 1003 -> {}",dao.update(new Person(1003, "Pieter", "Utrecht", new Date())));
		logger.info("All users -> {}",dao.findAll() );	
	}

}
