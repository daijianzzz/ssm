package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dao.UserDao;
import com.test.domain.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> pageQuery(Integer currentPage, Integer pageSize) {
        // 封装分页信息
        PageHelper.startPage(currentPage, pageSize);
        List<User> list = userDao.findAll();
        return new PageInfo<>(list);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
