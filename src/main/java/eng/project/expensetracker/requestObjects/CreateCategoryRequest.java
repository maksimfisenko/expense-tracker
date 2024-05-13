package eng.project.expensetracker.requestObjects;

import eng.project.expensetracker.enums.CategoryType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCategoryRequest {
    @Schema(example = "4bf1232b-8d50-4797-9694-75c0446ed60b")
    String userId;
    @Schema(example = "Transport")
    String name;
    @Schema(example = "#2ab2f2")
    String hex;
    @Schema(example = "EXPENSE / INCOME")
    String type;
}
