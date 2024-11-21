package PetStore.PetStore.Entity;

import java.util.List;

public class OrderRequest {

    private String userId; // ID of the user placing the order

    private List<OrderItemRequest> items; // List of items in the order

    // Getters and Setters

    public static class OrderItemRequest {
        private String productId; // ID of the product being ordered
        private int quantity;     // Quantity of the product

        // Getters and Setters
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
