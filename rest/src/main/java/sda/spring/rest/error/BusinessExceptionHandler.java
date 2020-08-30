package sda.spring.rest.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;
import sda.spring.rest.service.exception.UserNotFoundException;

import java.util.*;

@ControllerAdvice//ajutor pentru controller in tratarea exceptiilor
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    //cand va arunca aceasta exceptie va executa intructiunile din aceasta metoda
    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity emailAlreadyUsedException(EmailAlreadyUsedException businessException) {
        ErrorDetails errorDetails = getErrorDetails(
                businessException.getMessage(),
                businessException.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity emailAlreadyUsedException(UserNotFoundException businessException) {
        ErrorDetails errorDetails = getErrorDetails(
                businessException.getMessage(),
                businessException.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    private ErrorDetails getErrorDetails(String message, String validationType) {
        return new ErrorDetails()
                .setMessage(message)
                .setTimestamp(new Date())
                .setValidationType(validationType);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                          HttpHeaders headers,
                                                          HttpStatus status,
                                                          WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        List<ErrorDetails> errors = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errors.add(getErrorDetails(fieldError.getDefaultMessage(), "InputValidationException"));
        }

        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);

    }
}

