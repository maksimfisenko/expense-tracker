package eng.project.expensetracker.mappers;

import eng.project.expensetracker.dtos.TransactionDTO;
import eng.project.expensetracker.entities.Transaction;
import eng.project.expensetracker.requestObjects.CreateExpenseRequest;
import eng.project.expensetracker.requestObjects.CreateIncomeRequest;
import eng.project.expensetracker.requestObjects.CreateTransferRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    TransactionDTO toDTO(Transaction transaction);
    Transaction toEntity(TransactionDTO transactionDTO);
    Transaction toEntity(CreateExpenseRequest createExpenseRequest);
    Transaction toEntity(CreateIncomeRequest createIncomeRequest);
    Transaction toEntity(CreateTransferRequest createTransferRequest);
}
