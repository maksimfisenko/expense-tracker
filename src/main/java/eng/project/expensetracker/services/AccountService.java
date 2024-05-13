package eng.project.expensetracker.services;

import eng.project.expensetracker.dtos.AccountDTO;
import eng.project.expensetracker.entities.Account;
import eng.project.expensetracker.entities.User;
import eng.project.expensetracker.mappers.AccountMapper;
import eng.project.expensetracker.repos.AccountRepo;
import eng.project.expensetracker.repos.UserRepo;
import eng.project.expensetracker.requestObjects.CreateAccountRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {

    AccountMapper accountMapper;
    AccountRepo accountRepo;
    UserRepo userRepo;

    public AccountDTO createAccount(CreateAccountRequest createAccountRequest) {
        User userToBind = userRepo.findById(createAccountRequest.getUserId()).orElseThrow();
        Account accountToSave = accountMapper.toEntity(createAccountRequest);
        accountToSave.setUser(userToBind);
        return accountMapper.toDTO(accountRepo.save(accountToSave));
    }

    public List<AccountDTO> getUserAccounts(String userId) {
        return accountRepo.findByUserId(userId).stream().map(accountMapper::toDTO).toList();
    }

}
