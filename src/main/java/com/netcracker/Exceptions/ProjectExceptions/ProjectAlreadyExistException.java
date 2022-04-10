package com.netcracker.Exceptions.ProjectExceptions;

public class ProjectAlreadyExistException extends RuntimeException{
    public ProjectAlreadyExistException(String message) {
        super(message);
    }
}
