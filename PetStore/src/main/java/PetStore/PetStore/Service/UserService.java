package PetStore.PetStore.Service;


import java.util.Optional;

import PetStore.PetStore.Entity.User;

public interface UserService {
    User registerUser(User user);
    Optional<User> authenticateUser(String email, String password);
}
