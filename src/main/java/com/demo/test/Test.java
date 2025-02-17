package com.demo.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author by heyi
 * @description
 * @date 2023/7/14 15:20
 */
public class Test {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("123");
        set = new HashSet<>();
        set.add("abc");
        List<String> list = Arrays.asList("123", "456", "abc");
        Func<String, Boolean> func = set::contains;
        //System.out.println(func.apply("abc"));
        list.stream().filter(set::contains).collect(Collectors.toList()).forEach(System.out::println);
    }
}
