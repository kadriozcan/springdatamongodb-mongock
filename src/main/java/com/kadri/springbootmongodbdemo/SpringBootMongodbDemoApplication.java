package com.kadri.springbootmongodbdemo;

import com.kadri.springbootmongodbdemo.repository.ExpenseRepository;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongock
@EnableMongoRepositories(basePackageClasses = ExpenseRepository.class)
public class SpringBootMongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbDemoApplication.class, args);
    }

}
