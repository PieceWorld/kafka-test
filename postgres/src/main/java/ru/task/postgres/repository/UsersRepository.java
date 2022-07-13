package ru.task.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.task.postgres.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
