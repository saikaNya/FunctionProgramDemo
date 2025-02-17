package com.demo.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

    }


    /**
     * 使用 collect、forEach min max等终止符后 stream流不可再被重新使用
     */
    @Test
    public void steamCanOnlyStopOnce() {
        Stream<Integer> integerStream = Stream.of(3, 1, 2, null, 5, 4);
        Stream<Integer> nonNullStream = integerStream.filter(Objects::nonNull);
        //max 执行后已终止该  nonNullStream 流
        System.out.println(nonNullStream.max(Integer::compareTo).get());

        System.out.println(nonNullStream.min(Integer::compareTo).get());
    }

    /**
     * 在这个示例中，我们创建了一个嵌套的整数列表 nestedList。
     * 然后，我们使用 stream() 方法创建一个包含嵌套列表的 Stream，
     * 接着调用 flatMap 函数将每个内部列表转换为其自身的 Stream。
     * 最后，我们使用 collect 方法将所有数字收集到一个单独的 List<Integer> 中。
     */
    @Test
    public void flatMapDemo() {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flatList = nestedList.stream()
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

        System.out.println("Original list: " + nestedList);
        System.out.println("Flattened list: " + flatList);
    }
}
