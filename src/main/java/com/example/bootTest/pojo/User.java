package com.example.bootTest.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleted;
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime create_time;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;
    public User(String name, String password, Integer version, Integer deleted) {
        this.name = name;
        this.password = password;
        this.version = version;
        this.deleted = deleted;
    }
}
