package eng.project.expensetracker.services;

import eng.project.expensetracker.dtos.CategoryDTO;
import eng.project.expensetracker.entities.Category;
import eng.project.expensetracker.entities.Subcategory;
import eng.project.expensetracker.entities.User;
import eng.project.expensetracker.enums.CategoryType;
import eng.project.expensetracker.mappers.CategoryMapper;
import eng.project.expensetracker.repos.CategoryRepo;
import eng.project.expensetracker.repos.SubcategoryRepo;
import eng.project.expensetracker.repos.UserRepo;
import eng.project.expensetracker.requestObjects.CreateCategoryRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {

    CategoryMapper categoryMapper;
    CategoryRepo categoryRepo;
    UserRepo userRepo;
    SubcategoryRepo subcategoryRepo;

    public CategoryDTO createCategory(CreateCategoryRequest createCategoryRequest) {

        User userToBind = userRepo.findById(createCategoryRequest.getUserId()).orElseThrow();
        Category categoryToSave = categoryMapper.toEntity(createCategoryRequest);

        categoryToSave.setUser(userToBind);
        categoryToSave.setType(CategoryType.valueOf(createCategoryRequest.getType()));

        Category savedCategory = categoryRepo.save(categoryToSave);

        Subcategory subcategoryToAdd = Subcategory.builder()
                .name("Default")
                .category(savedCategory)
                .build();
        subcategoryRepo.save(subcategoryToAdd);
        savedCategory.getSubcategories().add(subcategoryToAdd);

        return categoryMapper.toDTO(savedCategory);
    }

    public List<CategoryDTO> getUserCategories(String userId) {
        return categoryRepo.findByUserId(userId).stream().map(categoryMapper::toDTO).toList();
    }

}
