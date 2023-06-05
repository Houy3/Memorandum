package os.memorandum.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder

@Schema(description = "Страница со списком объектов и общее количество страниц")
public class DtosPageWithCountOfPages<T> extends DtosPage<T> {

    @Schema(description = "Общее количество страниц")
    private int countOfPages;
}
