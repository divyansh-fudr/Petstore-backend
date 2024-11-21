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

import PetStore.PetStore.Entity.Order;
import PetStore.PetStore.Entity.OrderRequest;
import PetStore.PetStore.Entity.OrderResponse;
import PetStore.PetStore.Service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Endpoint to place a new order.
     *
     * @param orderRequest The request body containing order details.
     * @return ResponseEntity with the created order details or an error message.
     */
    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            // Call the service to place the order
            OrderResponse orderResponse = orderService.placeOrder(orderRequest);

            // Return the created order details
            return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
        } catch (Exception e) {
            // Return an error response in case of exceptions
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed to place order: " + e.getMessage());
        }
    }
    
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@RequestParam("userId") String userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }
    

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") String id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}
