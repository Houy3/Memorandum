package os.memorandum.dto.errors;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@Schema(description = "Сведения об ошибке")
public class ErrorDto {

    @Schema(description = "Время ошибки")
    private LocalDateTime time;

    @Schema(description = "Сообщение об ошибке")
    private String message;
}
