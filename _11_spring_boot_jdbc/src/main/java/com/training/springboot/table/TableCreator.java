package com.training.springboot.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TableCreator implements CommandLineRunner {
    @Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void run(String... args) throws Exception {
     String query="""
     		create table if not exists product(
     		   pid int primary key ,
     		   pname varchar(50),
     		   price decimal(10,2)
     		)
     		""";
    		 
    		  jdbcTemplate.execute(query);
    		  System.out.println("table is created");
    		  
	}

}
