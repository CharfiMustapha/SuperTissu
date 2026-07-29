package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.User;
import com.example.SuperTissu.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public User ajouterUser(User user) {
        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword())
        );
        return userRepository.save(user);
    }

    @Override
    public User modifierUser(User user) {
        if(userRepository.existsById(user.getIdUser())){
            User oldUser =
                    userRepository.findById(user.getIdUser()).get();
            // Password stays unchanged
            oldUser.setUsername(user.getUsername());
            oldUser.setEmail(user.getEmail());
            return userRepository.save(oldUser);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User non trouvé avec l'id : "
                        + user.getIdUser()
        );
    }

    @Override
    public void supprimerUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Object> loginUser(String username, String password) {
        // Search user by username
        User userFromDB = userRepository.findByUsername(username);
        if (userFromDB == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found !"
            );
        }
        // Check password
        boolean match = bCryptPasswordEncoder.matches(
                password,
                userFromDB.getPassword()
        );
        if (!match) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Username or Password incorrect !"
            );
        }
        // JWT claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("idUser", userFromDB.getIdUser());
        claims.put("username", userFromDB.getUsername());
        claims.put("email", userFromDB.getEmail());
        // Secret key
        SecretKey key = Keys.hmacShaKeyFor(
                "MySuperSecretKeyForJWTAuthentication123456"
                        .getBytes(StandardCharsets.UTF_8)
        );
        // Generate token
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        // Response
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", userFromDB.getUsername());
        response.put("message", "Login successful");
        return response;
    }
}