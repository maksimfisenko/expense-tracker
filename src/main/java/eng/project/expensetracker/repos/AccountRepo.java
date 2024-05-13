package eng.project.expensetracker.repos;

import eng.project.expensetracker.entities.Account;
import eng.project.expensetracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    List<Account> findByUserId(String userId);
}
