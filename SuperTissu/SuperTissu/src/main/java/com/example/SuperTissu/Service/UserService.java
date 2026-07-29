package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    User ajouterUser(User user);
    User modifierUser(User user);
    void supprimerUser(Long id);
    Optional<User> findById(Long id);
    List<User> findAll();
    Map<String,Object> loginUser(String username, String password);
}