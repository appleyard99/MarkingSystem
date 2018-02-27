package com.education.service;
import com.education.domain.User;

import java.util.List;

public interface IUserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    int insertUser(User user);

}

