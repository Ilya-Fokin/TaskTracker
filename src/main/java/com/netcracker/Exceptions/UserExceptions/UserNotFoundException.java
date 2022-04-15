package com.netcracker.Exceptions.UserExceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException() {
        super();
    }
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
