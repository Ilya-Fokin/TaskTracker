package com.netcracker.Exceptions.UserExceptions;

public class UserIsExistInProjectException extends RuntimeException{
    public UserIsExistInProjectException(String message) {
        super(message);
    }
}
