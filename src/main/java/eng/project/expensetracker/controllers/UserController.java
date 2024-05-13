package eng.project.expensetracker.controllers;

import eng.project.expensetracker.dtos.UserDTO;
import eng.project.expensetracker.requestObjects.CreateUserRequest;
import eng.project.expensetracker.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Users",
            summary = "Get All Users",
            description = "This request returns all users of the application."
    )
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Users",
            summary = "Create User",
            description = "This request creates a new user."
    )
    public UserDTO createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

}
