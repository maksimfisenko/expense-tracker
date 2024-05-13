package eng.project.expensetracker.requestObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateIncomeRequest {
    @Schema(example = "018f6e9e-b6ce-7314-aab4-f204085a0dcc")
    String accountId;
    @Schema(example = "018f6e9f-9e23-71bd-8f10-e7e081b07418")
    String subcategoryId;
    @Schema(example = "55.55")
    BigDecimal amount;
}
