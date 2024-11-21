package PetStore.PetStore.Repository;


import PetStore.PetStore.Entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(String userId);
}