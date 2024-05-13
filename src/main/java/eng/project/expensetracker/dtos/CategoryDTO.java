package eng.project.expensetracker.dtos;

import eng.project.expensetracker.enums.CategoryType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {
    @Schema(example = "018f6e3f-49fd-70e4-9146-793bf5817675")
    String id;
    @Schema(example = "Transport")
    String name;
    @Schema(example = "#2ab2f2")
    String hex;
    @Schema(example = "EXPENSE / INCOME")
    CategoryType type;
    List<SubcategoryDTO> subcategories;
}
