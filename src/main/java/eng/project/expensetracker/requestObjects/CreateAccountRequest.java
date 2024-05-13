package eng.project.expensetracker.requestObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountRequest {
    @Schema(example = "4bf1232b-8d50-4797-9694-75c0446ed60b")
    String userId;
    @Schema(example = "Tinkoff MIR Card")
    String name;
    @Schema(example = "55.55")
    BigDecimal balance;
}
