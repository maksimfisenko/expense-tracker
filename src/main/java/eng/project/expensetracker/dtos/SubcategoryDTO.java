package eng.project.expensetracker.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubcategoryDTO {
    @Schema(example = "018f6e41-00e2-7d17-871d-5fb8d58ae803")
    String id;
    @Schema(example = "default")
    String name;
}
