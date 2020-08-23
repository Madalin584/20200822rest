package sda.spring.rest.error;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private String details;
    private Date date;
    private String ValidationType;

    public ErrorDetails() {
    }

    public ErrorDetails(String message, String details, Date date, String validationType) {
        this.message = message;
        this.details = details;
        this.date = date;
        ValidationType = validationType;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ErrorDetails setDetails(String details) {
        this.details = details;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ErrorDetails setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getValidationType() {
        return ValidationType;
    }

    public ErrorDetails setValidationType(String validationType) {
        ValidationType = validationType;
        return this;
    }
}
