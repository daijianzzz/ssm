package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.domain.Code;
import com.test.domain.Result;
import com.test.domain.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{currentPage}/{pageSize}")
    public Result pageQuery(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageInfo<User> pageInfo = userService.pageQuery(currentPage, pageSize);
        return pageInfo != null ? new Result(Code.QUERY_OK, pageInfo) : new Result(Code.QUERY_FAIL, "分页查询失败");
    }

    @GetMapping("/{userId}")
    public Result findById(@PathVariable(value = "userId") Integer id) {
//        if (true) {
//            throw new BusinessException("id没有对应用户"); // 抛异常
//        }
        User user = userService.findById(id);
        return user != null ? new Result(Code.QUERY_OK, user) : new Result(Code.QUERY_FAIL, "根据id查询失败");
    }

    @PostMapping
    public Result save(User user) {
        int count = userService.save(user);
        return count > 0 ? new Result(Code.SAVE_OK) : new Result(Code.SAVE_FAIL, "保存失败");
    }
    @PutMapping
    public Result update(User user) {
        int count = userService.update(user);
        return count > 0 ? new Result(Code.UPDATE_OK) : new Result(Code.UPDATE_FAIL, "修改失败");

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        int count = userService.delete(id);
        return count > 0 ? new Result(Code.DELETE_OK) : new Result(Code.DELETE_FAIL, "删除失败");
    }

    @GetMapping("/login/{username}/{password}")
    public Result login(@PathVariable String username, @PathVariable String password) {
        User user = userService.login(username, password);
        return user != null ? new Result(Code.LOGIN_OK, user) : new Result(Code.LOGIN_FAIL, "登录失败");
    }
}
