package com.renta.renta.dataAccess;

import com.renta.renta.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByMail(String username);
}
