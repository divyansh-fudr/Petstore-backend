package PetStore.PetStore.Entity;

import java.util.List;

public class CartResponse {
	
    private String userId;  // To identify the user
    private double totalPrice;  // Total price of the cart
    private List<CartItem> items;  // List of items in the cart

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    // Inner class for CartItem
    public static class CartItem {

        private String productId;  // ID of the product
        private String name;  // Product name
        private int quantity;  // Quantity of the product
        private double unitPrice;  // Price per unit
        private double totalPrice;  // Total price for the product based on quantity

        // Getters and setters

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

}
