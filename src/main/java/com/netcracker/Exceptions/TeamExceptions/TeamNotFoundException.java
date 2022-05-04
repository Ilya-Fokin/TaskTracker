package com.netcracker.Exceptions.TeamExceptions;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamNotFoundException() {
        super();
    }
    public TeamNotFoundException(Throwable cause) {
        super(cause);
    }
}
