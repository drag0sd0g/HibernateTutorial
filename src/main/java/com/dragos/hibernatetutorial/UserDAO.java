package com.dragos.hibernatetutorial;

import java.util.List;

public interface UserDAO {

  void insertUser(User user);
  
  User getUserById(int userId);
  
  User getUser(String username);
  
  List<User> getUsers();

  int deleteAllUsers();

  void deleteUserById(int userId);
}