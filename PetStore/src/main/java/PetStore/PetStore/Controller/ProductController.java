package PetStore.PetStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PetStore.PetStore.ApiResponse.ApiResponse;
import PetStore.PetStore.Entity.Product;
import PetStore.PetStore.Service.ProductService;

@RestController
	@RequestMapping("/api")
	public class ProductController {
	    private final ProductService productService;

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    // GET endpoint to retrieve products by category ID
	    @GetMapping("/categories/{categoryId}/products")
	    public ResponseEntity<ApiResponse<List<Product>>> getProductsByCategory(
	            @PathVariable String categoryId) {
	        List<Product> products = productService.getProductsByCategoryId(categoryId);

	        if (!products.isEmpty()) {
	            ApiResponse<List<Product>> response = new ApiResponse<>(
	                    HttpStatus.OK.value(),
	                    "List of products in the category",
	                    products
	            );
	            return ResponseEntity.ok(response);
	        } else {
	            ApiResponse<List<Product>> response = new ApiResponse<>(
	                    HttpStatus.NOT_FOUND.value(),
	                    "Category not found",
	                    null
	            );
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    }
	    // POST endpoint to create a new product
	    // POST endpoint to create a new product
	    @PostMapping("/products")
	    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product) {
	        try {
	            // Create the product, ensuring it's linked to an existing category
	            Product createdProduct = productService.createProduct(product);

	            ApiResponse<Product> response = new ApiResponse<>(
	                    HttpStatus.CREATED.value(),
	                    "Product created successfully",
	                    createdProduct
	            );

	            return ResponseEntity.status(HttpStatus.CREATED).body(response);

	        } catch (RuntimeException e) {
	            ApiResponse<Product> response = new ApiResponse<>(
	                    HttpStatus.BAD_REQUEST.value(),
	                    "Category not found",
	                    null
	            );
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	        }
	    }
	    
	    @GetMapping("products/{id}")
	    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable String id) {
	        try {
	            Product product = productService.getProductById(id);

	            if (product == null) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
	                        new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Product not found", null));
	            }

	            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Product retrieved successfully", product));
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
	                    new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred", null));
	        }
	    }
	    
	    @GetMapping("/products")
	    public ResponseEntity<ApiResponse<List<Product>>> getProductsByCategory1(@RequestParam("categoryId") String categoryId) {
	        try {
	            // Fetch products by categoryId
	            List<Product> products = productService.getProductsByCategoryId(categoryId);

	            // If no products are found for the category, return a not found response
	            if (products.isEmpty()) {
	                ApiResponse<List<Product>> response = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "No products found for the specified category", null);
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	            }

	            // Otherwise, return the list of products
	            ApiResponse<List<Product>> response = new ApiResponse<>(HttpStatus.OK.value(), "Products retrieved successfully", products);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            // Handle any errors and return a server error response
	            ApiResponse<List<Product>> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred", null);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }
}


