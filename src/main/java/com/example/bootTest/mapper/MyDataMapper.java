package com.example.bootTest.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyDataMapper {
    void addData(String game,String work);
}
