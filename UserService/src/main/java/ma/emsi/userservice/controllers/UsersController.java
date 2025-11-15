package ma.emsi.userservice.controllers;

import ma.emsi.userservice.dtos.UsersDTO;
import ma.emsi.userservice.dtos.UsersResponseDTO;
import ma.emsi.userservice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    private final UsersService userService;

    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/by-ids")
    public List<UsersResponseDTO> getUsersByIds(@RequestBody List<Long> ids) {
        return userService.getUsersByIds(ids);
    }

    @GetMapping("/users")
    public List<UsersResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UsersResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/users")
    public UsersResponseDTO createUser(@RequestBody UsersDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
