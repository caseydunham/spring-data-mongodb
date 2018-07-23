package com.stackify.mongodb.services;

import com.stackify.mongodb.domain.Todo;
import com.stackify.mongodb.repositories.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

  @Autowired
  private TodoRepository todoRepository;

  @Override
  public Iterable<Todo> listAll() {
    return todoRepository.findAll();
  }

  @Override
  public Todo getById(String id) {
    return todoRepository.findById(id).orElse(null);
  }

  @Override
  public Todo saveOrUpdate(Todo todo) {
    todoRepository.save(todo);
    logger.info("Updated Todo: " + todo);
    return todo;
  }
}
