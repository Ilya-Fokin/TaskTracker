package com.netcracker.Service.UserService;

import com.netcracker.Domains.Project;
import com.netcracker.Domains.User;
import com.netcracker.Domains.UserProject;
import com.netcracker.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public void createUser(String name, String nickname, String password) {
        if (userRepo.findByNickname(nickname) == null) {
            User user = new User(name, nickname, new BCryptPasswordEncoder().encode(password));
            userRepo.save(user);
        }
    }

    @Override
    public User findByNickName(String nickname) {
        return userRepo.findByNickname(nickname);
    }

    @Override
    public User findByName(String name) {
        User user = userRepo.findByName(name);
        if (user == null) {
            throw new NullPointerException(String.format("Пользователь '%s' не найден", name));
        } else return user;
    }


}
