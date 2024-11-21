package PetStore.PetStore.ServiceIMP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PetStore.PetStore.Entity.CartRequest;
import PetStore.PetStore.Entity.CartResponse;
import PetStore.PetStore.Entity.Product;
import PetStore.PetStore.Repository.ProductRepository;
import PetStore.PetStore.Service.CartService;

@Service
public class CartServiceIMP implements CartService{
	@Autowired
    private ProductRepository productRepository;  // To fetch product details

    public CartResponse prepareCart(CartRequest request) {
        double totalPrice = 0;
        List<CartResponse.CartItem> cartItems = new ArrayList<>();

        // Loop through each item in the request
        for (CartRequest.CartItem itemRequest : request.getItems()) {
            // Fetch product by productId
            Product product = productRepository.findById(itemRequest.getProductId()).orElse(null);

            if (product != null) {
                CartResponse.CartItem cartItem = new CartResponse.CartItem();
                cartItem.setProductId(product.getId());
                cartItem.setQuantity(itemRequest.getQuantity());
                cartItem.setName(product.getName());
                cartItem.setUnitPrice(product.getPrice());
                cartItem.setTotalPrice(product.getPrice() * itemRequest.getQuantity());

                cartItems.add(cartItem);
                totalPrice += cartItem.getTotalPrice();
            }
        }

        // Create CartResponse object
        CartResponse response = new CartResponse();
        response.setUserId(request.getUserId());
        response.setTotalPrice(totalPrice);
        response.setItems(cartItems);

        return response;
    }

}
