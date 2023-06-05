package os.memorandum.dto.base;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public class LongIdDto implements Dto {

    @Schema(description = "Идентификатор")
    private Long id;
}
