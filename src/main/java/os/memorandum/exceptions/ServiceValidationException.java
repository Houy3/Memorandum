package os.memorandum.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import os.memorandum.services.base.ValidationError;


import java.util.List;

@Getter
@RequiredArgsConstructor
public class ServiceValidationException extends RuntimeException {

    private final List<ValidationError> errors;
}
