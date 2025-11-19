package com.puremike.db;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DbApplication implements CommandLineRunner {

    private DataSource dataSource;

    private DbApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("DataSource: " + dataSource);
        JdbcTemplate restJdbcTemplate = new JdbcTemplate(dataSource);
        restJdbcTemplate.execute("select 1");
    }

}
