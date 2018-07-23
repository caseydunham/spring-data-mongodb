package com.stackify.mongodb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserMongoRepositoryTest {

  @Autowired
  UserMongoRepository userMongoRepository;

  @Before
  public void setUp() throws Exception {
    User user1 = new User("Alice", 23);
    User user2 = new User("Bob", 38);
    //save product, verify has ID value after save
    assertNull(user1.getId());
    assertNull(user2.getId());//null before save
    userMongoRepository.save(user1);
    userMongoRepository.save(user2);
    assertNotNull(user1.getId());
    assertNotNull(user2.getId());
  }

  @Test
  public void testFetchData(){
    User userA = userMongoRepository.findByName("Bob");
    assertNotNull(userA);
    assertEquals(38, userA.getAge());

    Iterable<User> users = userMongoRepository.findAll();
    int count = 0;
    for(User p : users){
      count++;
    }
    assertEquals(count, 2);
  }

  @Test
  public void testDataUpdate(){
    User userB = userMongoRepository.findByName("Bob");
    userB.setAge(40);
    userMongoRepository.save(userB);
    User userC= userMongoRepository.findByName("Bob");
    assertNotNull(userC);
    assertEquals(40, userC.getAge());
  }

  @After
  public void tearDown() throws Exception {
    this.userMongoRepository.deleteAll();
  }

}
