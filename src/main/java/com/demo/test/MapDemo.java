package com.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

    }


    /**
     * Map.computeIfAbsent 是 Java 中 Map 接口的一个方法，
     * 用于在 Map 中获取指定键对应的值，如果该键不存在，则使用给定的函数计算其值，并将其添加到 Map 中
     *
     * 将单词映射到一个整数列表，这个列表记录了单词在给定数组中每次出现的位置
     */
    @Test
    public void computeIfAbsentDemo() {
        // 创建一个 Map，键为 String 类型，值为 List<Integer> 类型
        Map<String, List<Integer>> wordIndicesMap = new HashMap<>();

        // 添加一些单词到 Map 中
        String[] words = {"apple", "banana", "cherry", "apple", "banana", "apple"};

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 使用 computeIfAbsent 方法获取单词对应的索引列表
            // 如果单词已经存在于 Map 中，则直接返回索引列表
            // 如果不存在，则创建一个新的 ArrayList 并添加到 Map 中
            wordIndicesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
        }

        // 输出最终的单词索引 Map
        System.out.println("Final word indices map: " + wordIndicesMap);
    }

    /**
     * Map.merge 是 Java 中用于合并两个 Map 的方法。
     * 这个方法接受三个参数：一个键，一个值，
     * 以及一个处理相同键时的冲突解决方法（BiFunction）。
     *
     *
     *下面的Map：map1 和 map2。使用 map2.forEach 遍历 map2 中的所有键值对，
     * 并将它们合并到 map1 中。当两个 Map 中具有相同键时，
     * 使用一个简单的 BiFunction (v1, v2) -> v1 + v2 来解决冲突。
     * 这个 BiFunction 将两个具有相同键的值相加。
     */
    @Test
    public void MapMergeDemo() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        map2.put("D", 5);

        // 合并两个 Map
        map2.forEach((key, value) -> {
            map1.merge(key, value, Integer::sum);
        });

        System.out.println("合并后的 Map: " + map1);
    }

}
