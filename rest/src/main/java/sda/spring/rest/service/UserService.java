package sda.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.rest.model.User;
import sda.spring.rest.model.dto.UserDTO;
import sda.spring.rest.repository.UserRepository;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;
import sda.spring.rest.service.exception.UserNotFoundException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    //creeaza o legatura cu UserRepository, dependency injection
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public User updateStatus(Long id, User user){
        //return userRepository.save(getById(id).setStatus(user.getStatus()));
        userRepository.updateStatus(id, user.getStatus());
        return getById(id);
    }

    public User updateStatusNew(Long id, User user) {
        //aduce user-ul din DB
        User userFromDB = getById(id);
        //user-ului adus ii atribui field-ul status din obiectul primit ca parametru
        userFromDB.setStatus(user.getStatus());
        return userRepository.save(userFromDB);
    }
}
