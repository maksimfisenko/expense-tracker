package eng.project.expensetracker.repos;

import eng.project.expensetracker.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, String> {
    List<Subcategory> findByCategoryId(String categoryId);
}
