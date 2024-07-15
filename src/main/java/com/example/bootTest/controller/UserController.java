package com.example.bootTest.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bootTest.Result.ResultMsg;
import com.example.bootTest.Result.ResultUser;
import com.example.bootTest.pojo.User;
import com.example.bootTest.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @RequestMapping("/getId")
    public ResultUser userController(int id) {
       return  userService.getUserById(id);
    }
    @RequestMapping("/addUser")
    public ResultMsg addUser(String username, String password) {
        return userService.addUser(username, password);
    }
    @RequestMapping("/queryUserPage")
    public Page<User> getUserPage() {
        return userService.queryUserPage();
    }
    @RequestMapping("/deleteUser")
    public ResultMsg deleteUser(int id) {
        return userService.deleteUser(id);
    }
}
