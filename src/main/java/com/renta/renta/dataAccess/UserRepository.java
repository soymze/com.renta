package com.renta.renta.dataAccess;

import com.renta.renta.entities.Message;
import com.renta.renta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
