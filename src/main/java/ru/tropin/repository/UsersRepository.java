package ru.tropin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tropin.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
}
