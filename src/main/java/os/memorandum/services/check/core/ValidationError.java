package os.memorandum.services.check.core;


import lombok.Data;

@Data
public class ValidationError {


    private String field;

    private String message;

    private final boolean needToStop;

    public ValidationError(String field, String message) {
        this(field, message, false);
    }

    public ValidationError(String field, String message, boolean needToStop) {
        this.field = field;
        this.message = message;
        this.needToStop = needToStop;
    }

}
