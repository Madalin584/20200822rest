package sda.spring.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.spring.rest.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
