package sda.spring.rest.service.exception;

public class EmailAlreadyUsedException extends RuntimeException {
    //merge in contructorul clasei parinte cu super() si initializeaza mesajul
    public EmailAlreadyUsedException() {
        super("Email already used");
    }
}
