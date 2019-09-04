package com.example.springbootunittests.Service;

import javax.annotation.Resource;

import com.example.springbootunittests.Dao.UserDao;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public String getUser() {
        return userDao.getUser();
    }

}