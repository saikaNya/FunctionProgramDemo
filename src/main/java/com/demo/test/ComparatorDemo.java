package com.demo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        User u1 = new User("tom", null);
        User u2 = new User("cloud", 30);
        User u3 = new User("jane", 30);
        User u4 = new User(null, 15);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);


        //比较器匿名内部类写法
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User p1, User p2) {
                return p1.getScore().compareTo(p2.getScore());
            }
        };

        //lamda写法
        Comparator<User> comparatorLamda = (o1, o2) -> o1.getScore().compareTo(o2.getScore());


        //方法引用写法
        Comparator<User> comparatorMethodReference = Comparator.comparing(User::getScore);

        //按分数正序 分数为null排最后面
        Comparator<User> comparing1 = Comparator.comparing(User::getScore, Comparator.nullsLast(Comparator.naturalOrder()));
        users.stream().sorted(comparing1).forEach(System.out::println);


        System.out.println("------------------------------------------");

        //按分数倒序 分数为null排最后面
        Comparator<User> comparing = Comparator.comparing(User::getScore, Comparator.nullsLast(Comparator.reverseOrder()));
        users.stream().sorted(comparing).forEach(System.out::println);

        System.out.println("------------------------------------------");
        users.add(null);
        //对象为null排在最前面  之后按分数倒序 分数为null排最后面
        Comparator<User> userComparator = Comparator.nullsFirst(comparing);
        users.stream().sorted(userComparator).forEach(System.out::println);


        System.out.println("------------------------------------------");
        //对象为null排在最前面  之后按分数正序 分数为null排最后面  若分数相同  则再按姓名正序 姓名为null排在最后面
        Comparator<User> combineComparator = Comparator.nullsFirst(Comparator.comparing(User::getScore, Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(User::getName, Comparator.nullsLast(Comparator.naturalOrder())));
        users.stream().sorted(combineComparator).forEach(System.out::println);

        System.out.println("------------------------------------------");
        System.out.println(users.stream().max(combineComparator).get());
    }


}
