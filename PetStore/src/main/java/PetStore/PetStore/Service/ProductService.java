package PetStore.PetStore.Service;

import java.util.List;

import PetStore.PetStore.Entity.Product;

public interface ProductService {
	
	    List<Product> getProductsByCategoryId(String categoryId);
	    Product createProduct(Product product);
	    Product getProductById(String id);
	}

