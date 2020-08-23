package sda.spring.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.spring.rest.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    User findByNameContains(String name);

    User findByEmailAndPassword(String email, String password);

    List<User> findAll();

    Optional<User> findById(Long id);
}
