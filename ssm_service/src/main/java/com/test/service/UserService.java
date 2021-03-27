package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    @Transactional(readOnly = true)
    PageInfo<User> pageQuery(Integer currentPage, Integer pageSize);

    @Transactional(readOnly = true)
    User findById(Integer id);

    int save(User user);

    int update(User user);

    int delete(Integer id);

    @Transactional(readOnly = true)
    User login(String username, String password);
}
