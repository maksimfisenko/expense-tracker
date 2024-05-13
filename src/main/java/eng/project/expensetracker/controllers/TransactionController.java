package eng.project.expensetracker.controllers;

import eng.project.expensetracker.dtos.ExpenseDTO;
import eng.project.expensetracker.dtos.IncomeDTO;
import eng.project.expensetracker.dtos.TransactionDTO;
import eng.project.expensetracker.requestObjects.CreateExpenseRequest;
import eng.project.expensetracker.requestObjects.CreateIncomeRequest;
import eng.project.expensetracker.requestObjects.CreateTransferRequest;
import eng.project.expensetracker.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin
public class TransactionController {

    TransactionService transactionService;

    @PostMapping("/expense")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Transactions",
            summary = "Create Expense",
            description = "This request creates new expense of certain subcategory from certain account."
    )
    public TransactionDTO createExpense(@RequestBody CreateExpenseRequest createExpenseRequest) {
        return transactionService.createExpense(createExpenseRequest);
    }

    @PostMapping("/income")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Transactions",
            summary = "Create Income",
            description = "This request creates new income to certain account."
    )
    public TransactionDTO createIncome(@RequestBody CreateIncomeRequest createIncomeRequest) {
        return transactionService.createIncome(createIncomeRequest);
    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Transactions",
            summary = "Create Transfer",
            description = "This request creates new transfer from one account to another one."
    )
    public List<TransactionDTO> createTransfer(@RequestBody CreateTransferRequest createTransferRequest) {
        return transactionService.createTransfer(createTransferRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Transactions",
            summary = "Get User Transactions",
            description = "This request returns all user transactions."
    )
    public List<TransactionDTO> getUserTransactions(
            @Parameter(
                    example = "018f6ea5-9e30-7698-afa1-332797e09a71",
                    required = true) @RequestParam String userId) {
        return transactionService.getUserTransactions(userId);
    }

    @GetMapping("/expense")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Transactions",
            summary = "Get User Expenses",
            description = "This request returns all user expenses from certain time period."
    )
    public List<ExpenseDTO> getUserExpenses(
            @Parameter(
                    example = "018f6ea5-9e30-7698-afa1-332797e09a71",
                    required = true) @RequestParam String userId,
            @Parameter(
                    example = "2024-05-01T21:13:29+0000",
                    required = true) @RequestParam String startDate,
            @Parameter(
                    example = "2024-05-12T21:13:29+0000",
                    required = true) @RequestParam String endDate) {
        return transactionService.getUserExpenses(userId, startDate, endDate);
    }

    @GetMapping("/income")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Transactions",
            summary = "Get User Incomes",
            description = "This request returns all user incomes from certain time period."
    )
    public List<IncomeDTO> getUserIncomes(
            @Parameter(
                    example = "018f6ea5-9e30-7698-afa1-332797e09a71",
                    required = true) @RequestParam String userId,
            @Parameter(
                    example = "2024-05-01T21:13:29+0000",
                    required = true) @RequestParam String startDate,
            @Parameter(
                    example = "2024-05-12T21:13:29+0000",
                    required = true) @RequestParam String endDate) {
        return transactionService.getUserIncomes(userId, startDate, endDate);
    }

}
