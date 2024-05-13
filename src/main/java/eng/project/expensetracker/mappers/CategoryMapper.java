package eng.project.expensetracker.mappers;

import eng.project.expensetracker.dtos.CategoryDTO;
import eng.project.expensetracker.entities.Category;
import eng.project.expensetracker.requestObjects.CreateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {SubcategoryMapper.class})
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
    Category toEntity(CreateCategoryRequest createCategoryRequest);
}
