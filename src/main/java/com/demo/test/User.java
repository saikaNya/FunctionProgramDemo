package com.demo.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by heyi
 * @description
 * @date 2023/1/6 20:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //姓名
    private String name;

    //分数
    private Integer score;


    public static void main(String[] args) {
        Map<String, User> m = new HashMap<>();

    }


}

