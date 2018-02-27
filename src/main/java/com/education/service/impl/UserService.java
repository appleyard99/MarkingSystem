package com.education.service.impl;

import com.education.domain.User;
import com.education.mapper.UserMapper;
import com.education.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id.intValue());
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
