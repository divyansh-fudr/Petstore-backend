package PetStore.PetStore.Service;

import org.springframework.stereotype.Service;

import PetStore.PetStore.Entity.CartRequest;
import PetStore.PetStore.Entity.CartResponse;

public interface CartService {
	CartResponse prepareCart(CartRequest request);

}
