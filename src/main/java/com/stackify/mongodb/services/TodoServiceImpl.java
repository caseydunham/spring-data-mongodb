package com.stackify.mongodb.services;


import com.stackify.mongodb.domain.Todo;
import com.stackify.mongodb.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoRepository todoRepository;

  @Override
  public Iterable<Todo> listAll() {
    return todoRepository.findAll();
  }

}
