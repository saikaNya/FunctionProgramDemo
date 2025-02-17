//package com.demo.test;
//
//import java.util.Objects;
//
///**
// * 自定义函数式方法，仿FUNCTION
// *
// * @param <T> 入参类型
// * @param <R> 出参类型
// */
//@FunctionalInterface
//public interface Func<T, R> {
//
//    R apply(T t);
//
//    default <V> Func<V, R> compose(Func<? super V, ? extends T> before) {
//        System.out.println("--------compose run------------");
//        Objects.requireNonNull(before);
//        return (V v) -> this.apply(before.apply(v));
//    }
//
//    /**
//     * 接口的默认方法   可以调用实例化该函数式接口 的对象this
//     *
//     * @param after
//     * @param <V>
//     * @return
//     */
//    default <V> Func<T, V> andThen(Func<? super R, ? extends V> after) {
//        System.out.println("--------andThen run------------");
//        Objects.requireNonNull(after);
//        return (T t) -> after.apply(this.apply(t));
//    }
//
//    public static void main(String[] args) {
//        Func<Integer, Integer> func = x -> {
//            System.out.println("--------apply run------------");
//            return 2 * x;
//        };
////        Integer result = func.apply(2);
////        System.out.println(result);
//        Func<Integer, Integer> combineFunc = func.andThen(func).andThen(func);
//        /*Integer combineFuncResult = combineFunc.apply(2);
//        System.out.println(combineFuncResult);*/
//
//
//        Func<String, Integer> strLen = x -> {
//            System.out.println("---------strLen run-------");
//            return x.length();
//        };
//
//        Func<Integer, String> toHexString = x -> {
//            System.out.println("---------toHexString run-------");
//            return Integer.toHexString(x);
//        };
//
//        Func<Integer, Integer> compose = func.compose(strLen).compose(toHexString);
//        System.out.println(compose.apply(16));
//        System.out.println(Integer.toHexString(16).length() * 2);
//    }
//
//
//}
