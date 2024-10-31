package tech.flap.employeemanager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.flap.employeemanager.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
