package os.memorandum.dto.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorDto {

    @Schema(description = "Наименование объекта")
    private String objectName;

    @Schema(description = "Наименование поля")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fieldName;

    @Schema(description = "Сообщение")
    private String message;
}
