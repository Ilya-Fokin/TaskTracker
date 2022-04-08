package com.netcracker.Controllers;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.User;
import com.netcracker.Entity.UserProject;
import com.netcracker.Service.ProjectService.ProjectService;
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

    @GetMapping("/")
    public void mainPage() {
        /*System.out.println("hello");
        userService.createUser("Илья Фокин", "ilya3349", "468279135");
        userService.createUser("Никита Сергеевич", "nikitos", "461516521");
        //System.out.println(userService.findByNickName("ilya3349").toString());
        projectService.createProject("project", "description", LocalDateTime.now(), true, userService.findByNickName("ilya3349"));
        projectService.addProjectParticipant(projectService.findByName("project"), userService.findByNickName("nikitos"));
        User user = userService.findByNickName("ilya3349");*/
        User user = userService.findByNickName("ilya3349");

        System.out.println("----------------------------------------------------------");
        user.getUserProjects().forEach(x -> System.out.println(x.getProject().getName()));
        System.out.println("----------------------------------------------------------");
    }
}
