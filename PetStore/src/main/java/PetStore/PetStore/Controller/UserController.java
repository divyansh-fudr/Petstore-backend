package PetStore.PetStore.Controller;

import PetStore.PetStore.Entity.User;
import PetStore.PetStore.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody User user) {
        User createdUser = userService.registerUser(user);

      //for msg
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("user", createdUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password) {
        Optional<User> userOptional = userService.authenticateUser(email, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

         
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("accessToken", "someAccessToken"); 
            response.put("user", user);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
           
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }
}




