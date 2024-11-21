package PetStore.PetStore.Entity;

import java.util.List;

public class CartRequest {  
		
	private String userId;  // To identify the user
	private List<CartItem> items;  // List of items in the cart
	
	// Getters and setters
	
	public String getUserId() {
	    return userId;
	}
	
	public void setUserId(String userId) {
	    this.userId = userId;
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
	    private int quantity;  // Quantity of the product
	
	    // Getters and setters
	
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

}
