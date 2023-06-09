package os.memorandum.dto.base;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import os.memorandum.utils.mapper.Dto;

@SuperBuilder
@Data
@NoArgsConstructor
public class BaseDto implements Dto {

    @Schema(description = "Идентификатор")
    private Long id;
}
