package com.netcracker.Service.UserService;

import com.netcracker.Domains.Project;
import com.netcracker.Domains.User;
import com.netcracker.Domains.UserProject;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void createUser(String name, String nickName, String password);
    User findByNickName(String nickname);
    User findByName(String name);
}
