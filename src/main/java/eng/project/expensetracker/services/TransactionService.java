package eng.project.expensetracker.services;

import eng.project.expensetracker.dtos.ExpenseDTO;
import eng.project.expensetracker.dtos.IncomeDTO;
import eng.project.expensetracker.dtos.TransactionDTO;
import eng.project.expensetracker.entities.Account;
import eng.project.expensetracker.entities.Subcategory;
import eng.project.expensetracker.entities.Transaction;
import eng.project.expensetracker.enums.TransactionType;
import eng.project.expensetracker.mappers.TransactionMapper;
import eng.project.expensetracker.repos.AccountRepo;
import eng.project.expensetracker.repos.SubcategoryRepo;
import eng.project.expensetracker.repos.TransactionRepo;
import eng.project.expensetracker.requestObjects.CreateExpenseRequest;
import eng.project.expensetracker.requestObjects.CreateIncomeRequest;
import eng.project.expensetracker.requestObjects.CreateTransferRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionService {

    TransactionMapper transactionMapper;
    TransactionRepo transactionRepo;
    AccountRepo accountRepo;
    SubcategoryRepo subcategoryRepo;

    public List<TransactionDTO> getUserTransactions(String userId) {
        return transactionRepo.findTransactionsByUserId(userId).stream().map(transactionMapper::toDTO).toList();
    }

    public TransactionDTO createExpense(CreateExpenseRequest createExpenseRequest) {

        Account accountToBind = accountRepo.findById(createExpenseRequest.getAccountId()).orElseThrow();
        Subcategory subcategoryToBind = subcategoryRepo.findById(createExpenseRequest.getSubcategoryId()).orElseThrow();

        Transaction expenseToSave = transactionMapper.toEntity(createExpenseRequest);

        expenseToSave.setAccount(accountToBind);
        expenseToSave.setSubcategory(subcategoryToBind);
        expenseToSave.setType(TransactionType.EXPENSE);

        accountToBind.setBalance(accountToBind.getBalance().subtract(expenseToSave.getAmount()));
        expenseToSave.setBalanceAfter(accountToBind.getBalance());

        return transactionMapper.toDTO(transactionRepo.save(expenseToSave));
    }

    public TransactionDTO createIncome(CreateIncomeRequest createIncomeRequest) {

        Account accountToBind = accountRepo.findById(createIncomeRequest.getAccountId()).orElseThrow();
        Subcategory subcategoryToBind = subcategoryRepo.findById(createIncomeRequest.getSubcategoryId()).orElseThrow();

        Transaction incomeToSave = transactionMapper.toEntity(createIncomeRequest);

        incomeToSave.setType(TransactionType.INCOME);
        incomeToSave.setAccount(accountToBind);
        incomeToSave.setSubcategory(subcategoryToBind);

        accountToBind.setBalance(accountToBind.getBalance().add(incomeToSave.getAmount()));
        incomeToSave.setBalanceAfter(accountToBind.getBalance());

        return transactionMapper.toDTO(transactionRepo.save(incomeToSave));

    }

    public List<TransactionDTO> createTransfer(CreateTransferRequest createTransferRequest) {

        Account accountFromToBind = accountRepo.findById(createTransferRequest.getAccountFromId()).orElseThrow();
        Account accountToToBind = accountRepo.findById(createTransferRequest.getAccountToId()).orElseThrow();

        Transaction transferFromToSave = transactionMapper.toEntity(createTransferRequest);
        Transaction transferToToSave = transactionMapper.toEntity(createTransferRequest);

        transferFromToSave.setAccount(accountFromToBind);
        transferFromToSave.setType(TransactionType.TRANSFER_SEND);

        transferToToSave.setAccount(accountToToBind);
        transferToToSave.setType(TransactionType.TRANSFER_RECEIVE);

        accountFromToBind.setBalance(accountFromToBind.getBalance().subtract(transferFromToSave.getAmount()));
        accountToToBind.setBalance(accountToToBind.getBalance().add(transferFromToSave.getAmount()));

        transferFromToSave.setBalanceAfter(accountFromToBind.getBalance());
        transferToToSave.setBalanceAfter(accountToToBind.getBalance());

        return List.of(
                transactionMapper.toDTO(transactionRepo.save(transferFromToSave)),
                transactionMapper.toDTO(transactionRepo.save(transferToToSave))
        );
    }

    public List<ExpenseDTO> getUserExpenses(String userId, String startDate, String endDate) {
        LocalDateTime localDateTimeStart = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime localDateTimeEnd = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return transactionRepo.findUserExpenses(
                userId,
                localDateTimeStart.toInstant(ZoneOffset.UTC),
                localDateTimeEnd.toInstant(ZoneOffset.UTC)
        );
    }

    public List<IncomeDTO> getUserIncomes(String userId, String startDate, String endDate) {
        LocalDateTime localDateTimeStart = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime localDateTimeEnd = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return transactionRepo.findUserIncomes(
                userId,
                localDateTimeStart.toInstant(ZoneOffset.UTC),
                localDateTimeEnd.toInstant(ZoneOffset.UTC)
        );
    }

}
