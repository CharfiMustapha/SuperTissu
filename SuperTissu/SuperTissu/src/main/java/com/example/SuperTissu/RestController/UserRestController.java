package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.User;
import com.example.SuperTissu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserRestController {

    @Autowired
    private UserService userService;

    // Add user
    @PostMapping
    public ResponseEntity<User> ajouterUser(
            @RequestBody User user){
        User savedUser =
                userService.ajouterUser(user);
        return new ResponseEntity<>(
                savedUser,
                HttpStatus.CREATED
        );
    }

    // Modify user without changing password
    @PutMapping("/{id}")
    public ResponseEntity<User> modifierUser(
            @PathVariable Long id,
            @RequestBody User user){
        user.setIdUser(id);
        return ResponseEntity.ok(
                userService.modifierUser(user)
        );
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerUser(
            @PathVariable Long id){
        userService.supprimerUser(id);
        return ResponseEntity.noContent().build();
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable Long id){
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(
                        ResponseEntity.notFound().build()
                );
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(
                userService.findAll()
        );
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(
            @RequestBody Map<String,String> request){
        return ResponseEntity.ok(
                userService.loginUser(
                        request.get("username"),
                        request.get("password")
                )
        );
    }
}