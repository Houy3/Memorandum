package os.memorandum.services.check.core;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationError {


    private String objectName;
    private String fieldName;
    private String message;

    private final boolean needToStop;

    public ValidationError(String objectName, String fieldName, String message) {
        this(objectName, fieldName, message, false);
    }

    public ValidationError(String objectName, String fieldName, String message, boolean needToStop) {
        this.objectName = objectName;
        this.fieldName = fieldName;
        this.message = message;
        this.needToStop = needToStop;
    }

}
