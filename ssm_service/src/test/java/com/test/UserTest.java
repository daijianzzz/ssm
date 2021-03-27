package com.test;

import com.github.pagehelper.PageInfo;
import com.test.domain.User;
import com.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"}) // jar包的类中找
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        PageInfo<User> pageInfo = userService.pageQuery(1, 3);
        System.out.println("pageInfo---" + pageInfo.getList());
    }

    @Test
    public void test1() {
        User user = userService.findById(1);
        System.out.println("user---" + user);
    }

    @Test
    public void test2() {
        User user = new User();

        user.setUsername("七七212");
        user.setPassword("p77");
        user.setRealname("77");
        user.setGender("男");
        user.setBirthday("2010-01-01");
        userService.save(user);
    }

    @Test
    public void test3() {
        User user = new User();
        user.setId(1);
        user.setUsername("张三三三三");
        user.setPassword("p77");
        user.setRealname("77");
        user.setGender("男");
        user.setBirthday("2010-01-01");
        int count = userService.update(user);
        System.out.println("count---" + count);
    }

    @Test
    public void test4() {
        int count = userService.delete(12);
        System.out.println("count---" + count);
    }

    @Test
    public void test5() {
        User user = userService.login("李四", "22222");
        System.out.println("user---" + user);
    }

}
