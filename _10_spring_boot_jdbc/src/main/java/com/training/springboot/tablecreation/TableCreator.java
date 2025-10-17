package com.training.springboot.tablecreation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
class TableCreator implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public TableCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS employee (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(50) NOT NULL," +
                     "email VARCHAR(50) NOT NULL UNIQUE," +
                     "password VARCHAR(50) NOT NULL," +
                     "mobileNo BIGINT," +
                     "gender CHAR(1)," +
                     "isMarried BOOLEAN," +
                     "workingHour FLOAT," +
                     "salary DOUBLE," +
                     "dob DATE," +
                     "joinedAt DATETIME" +
                     ")";
        jdbcTemplate.execute(sql);
        System.out.println("Employee table created successfully!");
    }}
