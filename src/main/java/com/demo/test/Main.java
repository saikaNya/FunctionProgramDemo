package com.demo.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static Integer f(int x) {
        return 2 * x;
    }

    public static void main(String[] args) {
        /**
         * 函数式接口  Function<T, R>  有两个泛型 T与R
         * 有一个抽象方法  R apply(T t)  泛型T为apply方法入参类型  泛型R为apply方法出参类型
         * 所有函数式接口都有且只有一个抽象方法
         * 创建一个函数式对象  就是实现其函数式接口的唯一抽象方法
         * 所有函数式接口的泛型   一般都是定义其唯一抽象方法的 出参与入参类型
         */
        Function func;

        /**
         *匿名内部类写法  f(x) = 2x
         * 创建一个函数式对象 function1  即实现其抽象方法 R apply(T t)
         */
        Function<Integer, Integer> function1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return 2 * x;
            }
        };

        /**
         *lamda写法   f(x) = 2x;
         *  -> 左边是参数（可以是0到n个参数）   -> 右边是以左边参数为入参且返回或不返回一个参数的一个方法
         */
        Function<Integer, Integer> f1 = x -> {
            return 2 * x;
        };

        /**
         *lamda写法（简化版） f(x) = 2x;
         * lamda简化版当 -> 右边是的方法只有一行时可以简写  即去掉{ } ;与 return
         */
        Function<Integer, Integer> f2 = x -> 2 * x;

        //将右边的方法 提取成静态方法f(int x)
        Function<Integer, Integer> f3 = x -> f(x);

        //方法引用式写法
        Function<Integer, Integer> f4 = Main::f;

        Function<Integer, Integer> function = f1.andThen(f2).andThen(f4);
        Integer apply = function.apply(2);
        System.out.println(apply);


        /**
         *  静态方法的方法引用   函数式的入参就是静态方法的入参
         *  如  Predicate函数式接口的test方法  传入泛型T为String即   Predicate<String>时  入参为 String 返回值为boolean
         *  静态方法 StringUtils.isNotBlank()方法   入参为 String   返回值为boolean
         */
        Predicate<String> p = StringUtils::isNotBlank;
        boolean test = p.test("");
        System.out.println(test);


        /**
         *  成员方法的方法引用 对象本身this 加上成员方法的其他参数 作为入参
         *  如  Function函数式接口的apply方法  传入泛型T为String,Integer即   Function<String, Integer>  入参为 String 出参为 Integer
         *  成员方法 String.length   无入参  但成员方法会自带this作为入参  即 String  出参为Integer
         */
        Function<String, Integer> stringIntegerFunction = String::length;

        //另一个成员方法引用的示例
        BiFunction<LocalDate, LocalDate, Boolean> localDateLocalDateBooleanBiFunction = LocalDate::isAfter;
    }


    /**
     * 使用命令式编程方式  与函数式编程方式
     * 实现将该字符串中的数字  去重并按照数字顺序输出
     */
    public static final String STR = " 1 ,3,,2,45,7,a,b";

    /**
     * 命令式编程方式实现
     */
    @Test
    public void list() {
        List<Integer> result = new ArrayList<>();

        if (StringUtils.isNotBlank(STR)) {
            Set<Integer> set = new HashSet<>();
            String[] split = STR.split(",");
            for (String s1 : split) {
                if (StringUtils.isNotBlank(s1)) {
                    String trim = s1.trim();
                    if (StringUtils.isNumeric(trim)) {
                        int ele = Integer.parseInt(trim);
                        boolean add = set.add(ele);
                        if (add) {
                            result.add(ele);
                        }
                    }
                }
            }
            Collections.sort(result);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    /**
     * 函数式编程方式实现
     */
    @Test
    public void listF() {
        Arrays.stream(Optional.ofNullable(STR)
                        .filter(StringUtils::isNotBlank).orElse("").split(","))
                .filter(StringUtils::isNotBlank)
                .map(String::trim)
                .filter(StringUtils::isNumeric)
                .map(Integer::parseInt)
                .distinct().sorted().forEach(System.out::println);
    }

}
