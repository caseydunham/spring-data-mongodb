package com.stackify.mongodb.controllers;

import com.stackify.mongodb.domain.Todo;
import com.stackify.mongodb.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {

  @Autowired
  private TodoService todoService;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("todos", todoService.listAll());
    return "index";
  }

  @GetMapping("/todo/complete/{id}")
  public String complete(@PathVariable String id){
    Todo todo = todoService.getById(id);
    if (todo != null) {
      todo.setCompleted(Boolean.TRUE);
      todoService.saveOrUpdate(todo);
    }
    return "redirect:/";
  }

}
