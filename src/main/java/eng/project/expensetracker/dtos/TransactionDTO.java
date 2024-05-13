package eng.project.expensetracker.dtos;

import eng.project.expensetracker.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionDTO {
    @Schema(example = "018f6ea1-a1bd-7da1-aa53-bfd1fc55776e")
    String id;
    @Schema(example = "2024-05-12T21:06:10.123Z")
    Instant date;
    @Schema(example = "EXPENSE / INCOME / TRANSFER_RECEIVE / TRANSFER_SEND ")
    TransactionType type;
    @Schema(example = "55.55")
    BigDecimal amount;
    @Schema(example = "123.45")
    BigDecimal balanceAfter;
}
