package com.stackify.mongodb.components;

import com.stackify.mongodb.domain.Todo;
import com.stackify.mongodb.repositories.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

  @Autowired
  private TodoRepository todoRepository;

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
    seedData();
  }

  private void seedData() {
    Todo todo1 = todoRepository.save(new Todo("Pay car insurance"));
    logger.info("Created ToDo " + todo1);

    Todo todo2 = todoRepository.save(new Todo("Play more Skyrim"));
    logger.info("Created ToDo " + todo2);
  }

}