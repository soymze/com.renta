package com.renta.renta.dataAccess;

import com.renta.renta.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUserName(String username);

    boolean existsByUserName(String username);

    boolean existsByMail(String email);
}
