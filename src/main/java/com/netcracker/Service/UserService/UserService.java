package com.netcracker.Service.UserService;

import com.netcracker.Entity.User;

public interface UserService {
    void createUser(String name, String nickName, String password);
    User findByNickName(String nickname);
    User findByName(String name);
}
