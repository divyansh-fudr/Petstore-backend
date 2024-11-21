package PetStore.PetStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PetStore.PetStore.ApiResponse.ApiResponse;
import PetStore.PetStore.Entity.CartRequest;
import PetStore.PetStore.Entity.CartResponse;
import PetStore.PetStore.Service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {
	@Autowired
    private CartService cartService;

    @PostMapping("/prepareCart")
    public ResponseEntity<ApiResponse<CartResponse>> prepareCart(@RequestBody CartRequest request) {
        try {
            // Prepare the cart and calculate total price
            CartResponse cartResponse = cartService.prepareCart(request);

            // Return the cart response with total price and items
            ApiResponse<CartResponse> response = new ApiResponse<>(HttpStatus.OK.value(), "Cart prepared successfully", cartResponse);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle errors (e.g., invalid input, unavailable products)
            ApiResponse<CartResponse> response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Invalid input", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
