package eng.project.expensetracker.repos;

import eng.project.expensetracker.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {
    List<Category> findByUserId(String userId);
}
