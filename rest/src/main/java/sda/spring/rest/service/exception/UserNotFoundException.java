package sda.spring.rest.service.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found !");
    }
}
