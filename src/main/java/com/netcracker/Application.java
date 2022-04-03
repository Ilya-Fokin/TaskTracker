package com.netcracker;

import com.netcracker.Domains.Project;
import com.netcracker.Domains.User;
import com.netcracker.Service.ProjectService.ProjectService;
import com.netcracker.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
