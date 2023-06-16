package os.memorandum.dto.test;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import os.memorandum.utils.mapper.Dto;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Тест объект")
public class NewTestDto implements Dto {

    @Schema(description = "Тестовое поле")
    @NotNull
    private String testField;

    @Schema(description = "Тестовое поле2")
    private String testField2;

    @Schema(description = "Тестовое время")
    private LocalDateTime time;
}
