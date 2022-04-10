package com.netcracker.Service.UserService;

import com.netcracker.Entity.Project;
import com.netcracker.Entity.User;
import com.netcracker.Exceptions.UserExceptions.UserAlreadyExistException;
import com.netcracker.Exceptions.UserExceptions.UserNotFoundException;
import com.netcracker.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public void createUser(String name, String nickname, String password) {
        if (userRepo.findByNickname(nickname) == null) {
            User user = new User(name, nickname, new BCryptPasswordEncoder().encode(password));
            userRepo.save(user);
        } else throw new UserAlreadyExistException(String.format("Пользователь '%s' уже зарегистрирован", name));
    }

    @Override
    public User findByNickName(String nickname) {
        return userRepo.findByNickname(nickname);
    }

    @Override
    public User findByName(String name) {
        User user = userRepo.findByName(name);
        if (user == null) {
            throw new UserNotFoundException(String.format("Пользователь '%s' не найден", name));
        } else return user;
    }



}
