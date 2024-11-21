package PetStore.PetStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PetStore.PetStore.Entity.Category;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {
	

}
