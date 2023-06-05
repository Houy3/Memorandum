package os.memorandum.dto.test;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Тест объект")
public class NewTestDto {

    @Schema(description = "Тестовое поле")
    @NotNull
    @Size(max = 10)
    private String testField;

    @Schema(description = "Тестовое время")
    private LocalDateTime time;
}
