package savik.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import savik.website.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}