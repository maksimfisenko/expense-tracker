package eng.project.expensetracker.mappers;

import eng.project.expensetracker.dtos.SubcategoryDTO;
import eng.project.expensetracker.entities.Subcategory;
import eng.project.expensetracker.requestObjects.CreateSubcategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SubcategoryMapper {
    SubcategoryDTO toDTO(Subcategory subcategory);
    Subcategory toEntity(SubcategoryDTO subcategoryDTO);
    Subcategory toEntity(CreateSubcategoryRequest createSubcategoryRequest);
}
