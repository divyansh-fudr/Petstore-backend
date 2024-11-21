package PetStore.PetStore.ServiceIMP;

import PetStore.PetStore.Entity.Category;
import PetStore.PetStore.Repository.CategoryRepository;
import PetStore.PetStore.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import PetStore.PetStore.Repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import PetStore.PetStore.Service.CategoryService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceIMP implements CategoryService {
	@Autowired
    private  CategoryRepository categoryRepository;

    public CategoryServiceIMP(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        //category.setId(UUID.randomUUID().toString()); // Generate a unique ID for the new category
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }
    
}


