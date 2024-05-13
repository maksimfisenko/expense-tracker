package eng.project.expensetracker.requestObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTransferRequest {
    @Schema(example = "018f6e9e-b6ce-7314-aab4-f204085a0dcc")
    String accountFromId;
    @Schema(example = "018f6e9f-03d6-7437-b73d-56f027abe04f")
    String accountToId;
    @Schema(example = "55.55")
    BigDecimal amount;
}
