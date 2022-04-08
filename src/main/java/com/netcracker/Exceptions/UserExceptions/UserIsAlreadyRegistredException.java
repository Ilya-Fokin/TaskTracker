package com.netcracker.Exceptions.UserExceptions;

public class UserIsAlreadyRegistredException extends RuntimeException{
    public UserIsAlreadyRegistredException(String message) {
        super(message);
    }
}
