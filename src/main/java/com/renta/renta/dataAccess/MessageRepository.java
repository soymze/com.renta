package com.renta.renta.dataAccess;

import com.renta.renta.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
