package PetStore.PetStore.Repository;



import PetStore.PetStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	 // Custom query method to find user by email
    User findByEmail(String email);
}
