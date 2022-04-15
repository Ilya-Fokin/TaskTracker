package com.netcracker.Exceptions.AccessResrictionsException;

public class NoAccessException extends RuntimeException{
    public NoAccessException(String message) {
        super(message);
    }

    public NoAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAccessException() {
        super();
    }
    public NoAccessException(Throwable cause) {
        super(cause);
    }
}
