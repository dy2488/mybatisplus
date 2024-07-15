package com.example.bootTest.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleted;
    private String game;
    private String work;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
