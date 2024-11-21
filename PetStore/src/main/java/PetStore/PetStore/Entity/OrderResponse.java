package PetStore.PetStore.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public class OrderResponse {

    private String id;           // ID of the order
    private String userId;       // ID of the user who placed the order
    private UserDetails user;   // Details of the user

    private ZonedDateTime orderTime; // Timestamp of the order
    private double totalPrice;       // Total price of the order
    private String orderStatus;      // Status of the order (Pending, Shipped, Delivered)
    private List<OrderItemResponse> items; // List of ordered items

    // Nested UserResponse class
    public static class UserDetails {
        private String name;
        private String email;
        private String phone;
        private LocalDate dob;
        private String creationTime;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }
    }

    // Nested OrderItemResponse class
    public static class OrderItemResponse {
        private String productId;   // ID of the product
        private String name;        // Name of the product
        private int quantity;       // Quantity of the product
        private double unitPrice;   // Price per unit of the product
        private double totalPrice;  // Total price for the product (quantity × unitPrice)

        // Getters and Setters
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    }

    // Getters and Setters for OrderResponse
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public ZonedDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResponse> items) {
        this.items = items;
    }
}
