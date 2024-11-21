package PetStore.PetStore.Service;

import PetStore.PetStore.Entity.Category;
//
//import java.util.List;
//
//public interface CategoryService {
//
//    // Method to get categories based on ids, search term, page, and size
//    List<Category> getCategories(String ids, String searchTerm, int page, int size);
//}


import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
        Category createCategory(Category category);
        Optional<Category> getCategoryById(String id);  // New method
    }

