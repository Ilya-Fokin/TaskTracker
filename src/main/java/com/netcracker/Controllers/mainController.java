package com.netcracker.Controllers;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.User;
import com.netcracker.Entity.UserProject;
import com.netcracker.Service.ProjectService.ProjectService;
import com.netcracker.Service.TeamService.TeamService;
import com.netcracker.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class mainController {
    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public String mainPage(Model model) {
        return "Main";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login_page";
    }
}
