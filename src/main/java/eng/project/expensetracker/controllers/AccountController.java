package eng.project.expensetracker.controllers;

import eng.project.expensetracker.dtos.AccountDTO;
import eng.project.expensetracker.requestObjects.CreateAccountRequest;
import eng.project.expensetracker.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {

    AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Accounts",
            summary = "Create account",
            description = "This request creates a new account for some user."
    )
    public AccountDTO createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return accountService.createAccount(createAccountRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Accounts",
            summary = "Get User Accounts",
            description = "This request returns all accounts of some user."
    )
    public List<AccountDTO> getUserAccounts(
            @Parameter(
                    example = "018f6ea5-9e30-7698-afa1-332797e09a71",
                    required = true) @RequestParam String userId) {
        return accountService.getUserAccounts(userId);
    }

}
