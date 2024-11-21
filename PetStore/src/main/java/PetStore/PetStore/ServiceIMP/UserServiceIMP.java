package PetStore.PetStore.ServiceIMP;


import PetStore.PetStore.Entity.User;
import PetStore.PetStore.Repository.UserRepository;
import PetStore.PetStore.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceIMP implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        user.setCreationTime(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        
        if (user != null && user.getPassword().equals(password)) {
            return Optional.of(user);
        }
        
        return Optional.empty();
    }

    private String generateAccessToken(User user) {
        // Generate an access token. Replace with a real implementation if needed.
        return "sampleAccessTokenForUser_" + user.getId();
    }
}
