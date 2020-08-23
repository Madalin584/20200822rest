package sda.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.spring.rest.model.User;
import sda.spring.rest.service.UserService;
import sda.spring.rest.service.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getFirstUser() {
        return userService.getFirstUser();
    }

    //o mapare de tip GET la calea /users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User user1 = userService.getById(id);
        if (user1 == null) {
            throw new UserNotFoundException();
        }
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getName());
        userService.save(user1);
        return user1;
    }
}
