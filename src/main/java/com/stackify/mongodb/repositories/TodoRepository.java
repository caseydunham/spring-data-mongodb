package com.stackify.mongodb.repositories;

import com.stackify.mongodb.domain.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, String> {
}
