package com.stackify.mongodb.controllers;

import com.stackify.mongodb.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

  @Autowired
  private TodoService todoService;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("todos", todoService.listAll());
    return "index";
  }

}
