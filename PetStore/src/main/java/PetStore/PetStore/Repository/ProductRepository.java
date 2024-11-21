package PetStore.PetStore.Repository;

import PetStore.PetStore.Entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
	  List<Product> findByCategoryId(String categoryId);
}
