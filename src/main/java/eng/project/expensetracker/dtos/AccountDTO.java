package eng.project.expensetracker.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDTO {
    @Schema(example = "295d8673-84b3-4777-9faf-45db4f0f465a")
    String id;
    @Schema(example = "Tinkoff MIR Card")
    String name;
    @Schema(example = "55.55")
    BigDecimal balance;
}
