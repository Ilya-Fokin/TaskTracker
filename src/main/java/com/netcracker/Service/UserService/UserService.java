package com.netcracker.Service.UserService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.User;

import java.util.List;

public interface UserService {
    void createUser(String name, String nickName, String password);
    User findByNickname(String nickname);
    User findByName(String name);
}
