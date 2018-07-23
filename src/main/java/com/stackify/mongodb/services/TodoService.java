package com.stackify.mongodb.services;

import com.stackify.mongodb.domain.Todo;

public interface TodoService {
  Iterable<Todo> listAll();
}
