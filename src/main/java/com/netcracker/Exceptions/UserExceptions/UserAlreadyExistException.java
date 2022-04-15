package com.netcracker.Exceptions.UserExceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException() {
        super();
    }
    public UserAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
