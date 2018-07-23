package com.stackify.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, Integer> {
  User findByName(String name);
}
