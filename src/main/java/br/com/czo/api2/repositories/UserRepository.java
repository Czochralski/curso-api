package br.com.czo.api2.repositories;

import br.com.czo.api2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
