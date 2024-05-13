package eng.project.expensetracker.requestObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    @Schema(example = "Ivan Ivanov")
    String name;
    @Schema(example = "ivan.ivanov@gmail.com")
    String email;
    @Schema(example = "ZuYZydgMsOWVbEa")
    String password;
}
