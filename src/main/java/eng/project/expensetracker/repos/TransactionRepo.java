package eng.project.expensetracker.repos;

import eng.project.expensetracker.dtos.ExpenseDTO;
import eng.project.expensetracker.dtos.IncomeDTO;
import eng.project.expensetracker.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {
    @Query("SELECT t FROM Transaction t " +
            "WHERE t.account.user.id = :userId")
    List<Transaction> findTransactionsByUserId(@Param("userId") String userId);

    @Query(value = "SELECT new eng.project.expensetracker.dtos.ExpenseDTO" +
            "(t.id, t.date, t.type, t.amount, t.balanceAfter, t.account.name, c.name, s.name) " +
            "FROM Transaction t " +
            "LEFT JOIN Subcategory s on t.subcategory.id = s.id " +
            "LEFT JOIN Category c ON s.category.id = c.id " +
            "WHERE t.account.user.id = :userId AND t.type = 'EXPENSE' AND t.date BETWEEN :startDate AND :endDate")
    List<ExpenseDTO> findUserExpenses(@Param("userId") String userId,
                                      @Param("startDate") Instant startDate,
                                      @Param("endDate") Instant endDate);

    @Query(value = "SELECT new eng.project.expensetracker.dtos.IncomeDTO" +
            "(t.id, t.date, t.type, t.amount, t.balanceAfter, t.account.name, c.name, s.name) " +
            "FROM Transaction t " +
            "LEFT JOIN Subcategory s on t.subcategory.id = s.id " +
            "LEFT JOIN Category c ON s.category.id = c.id " +
            "WHERE t.account.user.id = :userId AND t.type = 'INCOME' AND t.date BETWEEN :startDate AND :endDate")
    List<IncomeDTO> findUserIncomes(@Param("userId") String userId,
                                    @Param("startDate") Instant startDate,
                                    @Param("endDate") Instant endDate);

}
