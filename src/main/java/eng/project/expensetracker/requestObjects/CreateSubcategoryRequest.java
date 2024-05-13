package eng.project.expensetracker.requestObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateSubcategoryRequest {
    @Schema(example = "018f6e3f-49fd-70e4-9146-793bf5817675")
    String categoryId;
    @Schema(example = "default")
    String name;
}
