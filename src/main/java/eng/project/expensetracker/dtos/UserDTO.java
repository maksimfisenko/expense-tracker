package eng.project.expensetracker.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    @Schema(example = "4bf1232b-8d50-4797-9694-75c0446ed60b")
    String id;
    @Schema(example = "Ivan Ivanov")
    String name;
    @Schema(example = "ivan.ivanov@gmail.com")
    String email;
    @Schema(example = "ZuYZydgMsOWVbEa")
    String password;
}
