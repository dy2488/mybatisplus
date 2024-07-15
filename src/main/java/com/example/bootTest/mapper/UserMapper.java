package com.example.bootTest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bootTest.pojo.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserMapper extends BaseMapper<User> {
    void addUserInfo(User user);
}
