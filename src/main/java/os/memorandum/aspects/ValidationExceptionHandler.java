package os.memorandum.aspects;

import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import os.memorandum.dto.base.DtosPage;
import os.memorandum.dto.errors.ValidationErrorDto;
import os.memorandum.exceptions.ServiceValidationException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler implements Ordered {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DtosPage<ValidationErrorDto>> handleControllerValidationException(MethodArgumentNotValidException ex) {
        List<ValidationErrorDto> validationErrors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            validationErrors.add(ValidationErrorDto.builder()
                    .objectName(error.getObjectName())
                    .fieldName(error instanceof FieldError ? ((FieldError)error).getField() : null)
                    .message(error.getDefaultMessage())
                    .build());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(DtosPage.<ValidationErrorDto>builder()
                        .dtos(validationErrors)
                        .build());
    }

    @ExceptionHandler(ServiceValidationException.class)
    public ResponseEntity<DtosPage<ValidationErrorDto>> handleServiceValidationException(ServiceValidationException ex) {
        List<ValidationErrorDto> validationErrors = new ArrayList<>();

        ex.getErrors().forEach(error -> validationErrors.add(ValidationErrorDto.builder()
                .objectName(error.getObjectName())
                .fieldName(error.getFieldName())
                .message(error.getMessage())
                .build()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(DtosPage.<ValidationErrorDto>builder()
                        .dtos(validationErrors)
                        .build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
