package eng.project.expensetracker.mappers;

import eng.project.expensetracker.dtos.AccountDTO;
import eng.project.expensetracker.entities.Account;
import eng.project.expensetracker.requestObjects.CreateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO accountDTO);
    Account toEntity(CreateAccountRequest createAccountRequest);;
}
