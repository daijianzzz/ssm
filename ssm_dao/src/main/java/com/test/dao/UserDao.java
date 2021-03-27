package com.test.dao;

import com.test.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);

    int save(User user);

    int update(User user);

    int delete(Integer id);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
