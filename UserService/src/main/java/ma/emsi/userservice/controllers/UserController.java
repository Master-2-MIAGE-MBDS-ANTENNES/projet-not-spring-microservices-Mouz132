package ma.emsi.userservice.controllers;

import ma.emsi.userservice.entities.User;
import ma.emsi.userservice.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepositories userRepositories;


    @Autowired
    public UserController(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepositories.findById(id).orElse(null);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepositories.deleteById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepositories.save(user);
    }
}
