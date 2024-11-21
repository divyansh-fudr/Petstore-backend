package PetStore.PetStore.Repository;


import PetStore.PetStore.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}