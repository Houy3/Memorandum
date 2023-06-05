package os.memorandum.dto.test;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import os.memorandum.dto.base.LongIdDto;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@Data
@Schema(description = "Тест объект")
public class TestDto extends LongIdDto {

    @Schema(description = "Тестовое поле")
    private String testField;

    @Schema(description = "Тестовое время")
    private LocalDateTime time;
}