package com.example.bootTest.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bootTest.Result.ResultMsg;
import com.example.bootTest.Result.ResultUser;
import com.example.bootTest.mapper.UserMapper;
import com.example.bootTest.pojo.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public ResultUser getUserById(Integer id) {
        User user = userMapper.selectById(id);
        return new ResultUser(user.getName(),user.getPassword());
    }
    public ResultMsg addUser(String username, String password)
    {
        try {
            HashMap<String,Object> nameMap= new HashMap<>();
            nameMap.put("name",username);
            List<User> users = userMapper.selectByMap(nameMap);
            System.out.println(users);
            if(users.isEmpty())
            {
                User user = new User(username, password,1,0);
                userMapper.insert(user);
                return new ResultMsg("插入成功");
            }else{
                return new ResultMsg("该用户已存在");
            }
        }
        catch (Exception e){
            return new ResultMsg("插入失败");
        }
    }
    public Page<User> queryUserPage(){
        Page<User> userPage= new Page<>(1, 5);
        return userMapper.selectPage(userPage, null);
    }
    public ResultMsg deleteUser(int id)
    {
        if(userMapper.deleteById(id)>0)
        {
            return new ResultMsg("删除成功");
        }else{
            return new ResultMsg("删除失败");
        }

    }

}
