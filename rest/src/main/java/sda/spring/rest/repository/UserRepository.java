package sda.spring.rest.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.spring.rest.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    User findByNameContains(String name);

    User findByEmailAndPassword(String email, String password);

    List<User> findAll();

    Optional<User> findById(Long id);

    @Transactional
    @Modifying
    @Query("update User u set u.status=:status where u.id=:id")
    void updateStatus(Long id, String status);
}
