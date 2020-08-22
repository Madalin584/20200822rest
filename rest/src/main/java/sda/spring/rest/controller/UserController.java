package sda.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.spring.rest.model.User;
import sda.spring.rest.service.UserService;

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
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok().body(new User()
                .setId(1L)
                .setEmail("email@yahoo.com")
                .setName("Madalin")
        );
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
