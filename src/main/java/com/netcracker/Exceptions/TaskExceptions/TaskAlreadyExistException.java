package com.netcracker.Exceptions.TaskExceptions;

public class TaskAlreadyExistException extends RuntimeException{
    public TaskAlreadyExistException(String message) {
        super(message);
    }

    public TaskAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskAlreadyExistException() {
        super();
    }
    public TaskAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
