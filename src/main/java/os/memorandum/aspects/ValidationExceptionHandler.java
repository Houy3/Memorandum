package os.memorandum.aspects;

import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import os.memorandum.dto.errors.ValidationErrorDto;
import os.memorandum.exceptions.ServiceValidationException;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class ValidationExceptionHandler implements Ordered {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ValidationErrorDto>> handleValidationsException(ConstraintViolationException ex) {
        List<ValidationErrorDto> validationErrors = new ArrayList<>();

        ex.getConstraintViolations().forEach(error -> {
            String field = error.getPropertyPath().toString();
            field = field.substring(field.lastIndexOf('.') + 1);

            validationErrors.add(ValidationErrorDto.builder()
                    .field(field)
                    .message(error.getMessage())
                    .build());
        } );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(validationErrors);
    }

    @ExceptionHandler(ServiceValidationException.class)
    public ResponseEntity<List<ValidationErrorDto>> handleServiceValidationException(ServiceValidationException ex) {
        List<ValidationErrorDto> validationErrors = new ArrayList<>();

        ex.getErrors().forEach(error -> validationErrors.add(ValidationErrorDto.builder()
                .field(error.getField())
                .message(error.getMessage())
                .build()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(validationErrors);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
