package com.netcracker.Exceptions.TeamExceptions;

public class TeamAlreadyExistException extends RuntimeException{
    public TeamAlreadyExistException(String message) {
        super(message);
    }

    public TeamAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamAlreadyExistException() {
        super();
    }
    public TeamAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
