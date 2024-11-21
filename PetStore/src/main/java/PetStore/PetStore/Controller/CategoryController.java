package PetStore.PetStore.Controller;

import PetStore.PetStore.ApiResponse.ApiResponse;

import PetStore.PetStore.Entity.Category;

import PetStore.PetStore.Repository.CategoryRepository;
import PetStore.PetStore.Service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET endpoint to retrieve all categories
    
       
//    @GetMapping(produces = "application/json")
//    public ResponseEntity<List<Category>> getAllCategories() {
//        List<Category> categories = categoryService.getAllCategories();
//        if (categories.isPresent()) {
//            ApiResponse<Category> response = new ApiResponse<>(HttpStatus.OK.value(), 
//            		 "List of products in the category", categoryOptional.get());
//            return ResponseEntity.ok(response);
//        } else {
//            ApiResponse<Category> response = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Category not found", null);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
    @GetMapping(produces = "application/json")
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        
        if (!categories.isEmpty()) {
            ApiResponse<List<Category>> response = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Paginated List of categories",
                    categories
            );
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<List<Category>> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Categories not found",
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    
       // return ResponseEntity.ok(categories);
    

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.createCategory(category);

      return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    
    // GET endpoint to retrieve a category by ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable String id) {
        Optional<Category> categoryOptional = categoryService.getCategoryById(id);

        if (categoryOptional.isPresent()) {
            ApiResponse<Category> response = new ApiResponse<>(HttpStatus.OK.value(), 
            		 "List of products in the category", categoryOptional.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Category> response = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Category not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}





