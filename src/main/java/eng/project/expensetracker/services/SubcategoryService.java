package eng.project.expensetracker.services;

import eng.project.expensetracker.dtos.SubcategoryDTO;
import eng.project.expensetracker.entities.Category;
import eng.project.expensetracker.entities.Subcategory;
import eng.project.expensetracker.mappers.SubcategoryMapper;
import eng.project.expensetracker.repos.CategoryRepo;
import eng.project.expensetracker.repos.SubcategoryRepo;
import eng.project.expensetracker.requestObjects.CreateSubcategoryRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubcategoryService {

    SubcategoryMapper subcategoryMapper;
    SubcategoryRepo subcategoryRepo;
    CategoryRepo categoryRepo;

    public SubcategoryDTO createSubcategory(CreateSubcategoryRequest createSubcategoryRequest) {
        Category categoryToBind = categoryRepo.findById(createSubcategoryRequest.getCategoryId()).orElseThrow();
        Subcategory subcategoryToSave = subcategoryMapper.toEntity(createSubcategoryRequest);
        subcategoryToSave.setCategory(categoryToBind);
        return subcategoryMapper.toDTO(subcategoryRepo.save(subcategoryToSave));
    }

    public List<SubcategoryDTO> getCategorySubcategories(String categoryId) {
        return subcategoryRepo.findByCategoryId(categoryId).stream().map(subcategoryMapper::toDTO).toList();
    }

}
