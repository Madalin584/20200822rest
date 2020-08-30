package sda.spring.rest.error;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private String validationType;
    private Date timestamp;

    public ErrorDetails() {
    }

    public String getMessage() {
        return message;
    }

    public ErrorDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ErrorDetails setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getValidationType() {
        return validationType;
    }

    public ErrorDetails setValidationType(String validationType) {
        this.validationType = validationType;
        return this;
    }

}
