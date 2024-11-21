package PetStore.PetStore.ServiceIMP;


import PetStore.PetStore.Entity.Order;
import PetStore.PetStore.Entity.OrderItem;
import PetStore.PetStore.Entity.OrderRequest;
import PetStore.PetStore.Entity.OrderResponse;
import PetStore.PetStore.Entity.Product;
import PetStore.PetStore.Entity.User;
import PetStore.PetStore.Repository.OrderItemRepository;
import PetStore.PetStore.Repository.OrderRepository;
import PetStore.PetStore.Repository.ProductRepository;
import PetStore.PetStore.Repository.UserRepository;
import PetStore.PetStore.Service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceIMP implements OrderService{
	
		@Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private OrderItemRepository orderItemRepository;

	    @Autowired
	    private UserRepository userRepository; // To fetch user details

	    public OrderResponse placeOrder(OrderRequest orderRequest) {
	        // Create a new Order entity
	        Order order = new Order();
	        order.setId(UUID.randomUUID().toString()); // Generate a unique order ID
	        order.setUserId(orderRequest.getUserId());
	        order.setOrderTime(ZonedDateTime.now()); // Set current time for the order
	        
	        // Calculate total price by iterating over the items in the order
	        double totalPrice = 0;
	        List<OrderItem> orderItems = new ArrayList<>();
	        
	        for (OrderRequest.OrderItemRequest itemRequest : orderRequest.getItems()) {
	            // Create order items and associate with the order
	        	Product product = productRepository.findById(itemRequest.getProductId()).orElse(null);
	        	
	            OrderItem orderItem = new OrderItem();
	            orderItem.setId(UUID.randomUUID().toString()); // Generate unique item ID
	            orderItem.setOrderID(order.getId());
	            orderItem.setOrder(order);
	            orderItem.setName(product.getName());
	            orderItem.setProductId(itemRequest.getProductId());
	            orderItem.setQuantity(itemRequest.getQuantity());
	            orderItem.setUnitPrice(product.getPrice()); // Set dummy unit price for now
	            orderItem.setTotalPrice(product.getPrice() * itemRequest.getQuantity());
	            
	            // Add item to the order
	            orderItems.add(orderItem);
	            totalPrice += orderItem.getTotalPrice();
	        }

	        // Set total price for the order
	        order.setTotalPrice(totalPrice);

	        // Save the order to the repository
	        orderRepository.save(order);

	        // Save the order items to the repository
	        orderItemRepository.saveAll(orderItems);

	        // Fetch user details from the userRepository
	        User user = userRepository.findById(orderRequest.getUserId()).orElse(null);

	        // Create OrderResponse to return
	        OrderResponse orderResponse = new OrderResponse();
	        orderResponse.setId(order.getId());
	        orderResponse.setUserId(order.getUserId());
	        
	        // If user is found, set user details
	        if (user != null) {
	            OrderResponse.UserDetails userDetails = new OrderResponse.UserDetails();
	            userDetails.setName(user.getName());
	            userDetails.setEmail(user.getEmail());
	            userDetails.setPhone(user.getPhone());
	            userDetails.setDob(user.getDob());
	            userDetails.setCreationTime(user.getCreationTime().toString());  // Adjust format as needed
	            orderResponse.setUser(userDetails);
	        }

	        orderResponse.setOrderTime(order.getOrderTime());
	        orderResponse.setTotalPrice(order.getTotalPrice());
	        
	        // Add items to the response
	        List<OrderResponse.OrderItemResponse> itemResponses = new ArrayList<>();
	        for (OrderItem orderItem : orderItems) {
	        	
	        	
	            OrderResponse.OrderItemResponse itemResponse = new OrderResponse.OrderItemResponse();
	            itemResponse.setProductId(orderItem.getProductId());
	            itemResponse.setName("Product Name"); // Set name (use actual product name from DB)
	            itemResponse.setQuantity(orderItem.getQuantity());
	            itemResponse.setUnitPrice(orderItem.getUnitPrice());
	            itemResponse.setTotalPrice(orderItem.getTotalPrice());
	            itemResponses.add(itemResponse);
	        }
	        orderResponse.setItems(itemResponses);

	        return orderResponse; // Return the order response with order details
	    }
	    

	    public List<Order> getOrdersByUserId(String userId) {
	        return orderRepository.findByUserId(userId);
	    }
	    
	    public Order getOrderById(String id) {
	        return orderRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
	    }
	    
	}