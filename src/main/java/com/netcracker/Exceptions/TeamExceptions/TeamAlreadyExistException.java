package com.netcracker.Exceptions.TeamExceptions;

public class TeamAlreadyExistException extends RuntimeException{
    public TeamAlreadyExistException(String message) {
        super(message);
    }
}
