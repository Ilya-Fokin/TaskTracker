package com.netcracker.Exceptions.ProjectExceptions;

public class ProjectAlreadyExistException extends RuntimeException{
    public ProjectAlreadyExistException(String message) {
        super(message);
    }

    public ProjectAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectAlreadyExistException() {
        super();
    }
    public ProjectAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
