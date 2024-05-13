package eng.project.expensetracker.controllers;

import eng.project.expensetracker.dtos.SubcategoryDTO;
import eng.project.expensetracker.requestObjects.CreateSubcategoryRequest;
import eng.project.expensetracker.services.SubcategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin
public class SubcategoryController {

    SubcategoryService subcategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Subcategories",
            summary = "Create Subcategory",
            description = "This request creates new subcategory of certain category."
    )
    public SubcategoryDTO createSubcategory(@RequestBody CreateSubcategoryRequest createSubcategoryRequest) {
        return subcategoryService.createSubcategory(createSubcategoryRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Subcategories",
            summary = "Get Category Subcategories",
            description = "This request returns all subcategories of certain category."
    )
    public List<SubcategoryDTO> getCategorySubcategories(
            @Parameter(
                    example = "018f6ea5-9e30-7698-afa1-332797e09a71",
                    required = true) @RequestParam String categoryId) {
        return subcategoryService.getCategorySubcategories(categoryId);
    }
    
}
