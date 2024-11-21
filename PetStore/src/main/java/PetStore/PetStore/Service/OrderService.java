package PetStore.PetStore.Service;

import java.util.List;

import PetStore.PetStore.Entity.Order;
import PetStore.PetStore.Entity.OrderRequest;
import PetStore.PetStore.Entity.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
    List<Order> getOrdersByUserId(String userId);
    Order getOrderById(String id);
}
