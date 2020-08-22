package sda.spring.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.spring.rest.model.User.User;

@RestController
@RequestMapping("/api")
public class UserController {
    //POJO + metadate = Bean

    public ResponseEntity<User> getAllUsers(){
        return ResponseEntity.ok().body(new User()
                        .setId(1L)
                        .setEmail("email@yahoo.com")
                        .setName("Madalin")
        );
    }

}
