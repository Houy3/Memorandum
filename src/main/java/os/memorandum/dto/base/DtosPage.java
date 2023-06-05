package os.memorandum.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@SuperBuilder
@NoArgsConstructor
@Schema(description = "Страница со списком объектов")
public class DtosPage<T> {

    @Schema(description = "Список объектов")
    private List<T> dtos;
}
