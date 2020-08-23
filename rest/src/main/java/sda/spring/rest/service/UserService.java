package sda.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.rest.model.User;
import sda.spring.rest.repository.UserRepository;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;
import sda.spring.rest.service.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    //creeaza o legatura cu UserRepository, dependency injection
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getFirstUser() {
        return new User()
                .setId(1L)
                .setEmail("email@yahoo.com")
                .setName("Madalin");
    }

    public User save(User user) {
        User userInDB = userRepository.findByEmail(user.getEmail());
        if (userInDB != null) {
            throw new EmailAlreadyUsedException();
        }
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
