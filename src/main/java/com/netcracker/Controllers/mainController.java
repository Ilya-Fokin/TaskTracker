package com.netcracker.Controllers;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.User;
import com.netcracker.Entity.UserProject;
import com.netcracker.Service.ProjectService.ProjectService;
import com.netcracker.Service.TeamService.TeamService;
import com.netcracker.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public void mainPage() {
        User user = userService.findByNickName("ilya3349");

        System.out.println("----------------------------------------------------------");
        user.getUserProjects().forEach(x -> teamService.findAllByProject(x.getProject()).forEach(y -> System.out.println(y.getName()+ " | " + y.getProject().getName())));


        System.out.println("----------------------------------------------------------");




    }
}
