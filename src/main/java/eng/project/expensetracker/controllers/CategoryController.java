package eng.project.expensetracker.controllers;

import eng.project.expensetracker.dtos.CategoryDTO;
import eng.project.expensetracker.requestObjects.CreateCategoryRequest;
import eng.project.expensetracker.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {

    CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Categories",
            summary = "Create Category",
            description = "This request creates a new category for certain user."
    )
    public CategoryDTO createCategory(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.createCategory(createCategoryRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Categories",
            summary = "Get User Categories",
            description = "This request returns all categories of certain user by user ID."
    )
    public List<CategoryDTO> getUserCategories(
            @Parameter(
                    example = "018f6ea5-9e30-7698-afa1-332797e09a71",
                    required = true) @RequestParam String userId) {
        return categoryService.getUserCategories(userId);
    }
    
}
