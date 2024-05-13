package eng.project.expensetracker.dtos;

import eng.project.expensetracker.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseDTO {
    @Schema(example = "2be3d9b8-5526-4c91-9ded-d44913778d40")
    String id;
    @Schema(example = "2024-05-12T23:35:47.311223Z")
    Instant date;
    @Schema(example = "EXPENSE")
    TransactionType type;
    @Schema(example = "55.55")
    BigDecimal amount;
    @Schema(example = "123.45")
    BigDecimal balanceAfter;
    @Schema(example = "Tinkoff MIR Card")
    String accountName;
    @Schema(example = "Transport")
    String categoryName;
    @Schema(example = "default")
    String subcategoryName;
}
