package PetStore.PetStore.ServiceIMP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PetStore.PetStore.Entity.Category;
import PetStore.PetStore.Entity.Product;
import PetStore.PetStore.Repository.CategoryRepository;
import PetStore.PetStore.Repository.ProductRepository;
import PetStore.PetStore.Service.ProductService;

@Service
public class ProductServiceIMP implements ProductService {
	 @Autowired
    private  ProductRepository productRepository;
	 @Autowired
	 private  CategoryRepository categoryRepository;


   
    public ProductServiceIMP(ProductRepository productRepository) {  // Corrected constructor name
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
    @Override
    public Product createProduct(Product product) {
        // Fetch the category by categoryId
        Category category = categoryRepository.findById(product.getCategoryKEID())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Set the category in the product
        product.setCategory(category);

        // Save the product
        return productRepository.save(product);
    }
    
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }
}
