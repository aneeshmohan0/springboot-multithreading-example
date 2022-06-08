package com.javatechie.executor.api.config;

import org.springframework.data.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Test1 {

    private static int getValue(int[] values) {

        //1234 678
        final List<Integer> integers = Optional.ofNullable(values)
                .map(value -> Arrays.stream(value)
                        .boxed()
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return integers.stream().filter(n -> n > 0).filter(n -> n % 4 == 0).max(Comparator.naturalOrder()).orElse(4);


    }


    private static int getValue1(String values) {

        final char[] chars = values.toCharArray();
        final Map<String, List<String>> collect = IntStream.range(0, values.length()).mapToObj(i -> String.valueOf(chars[i])).collect(groupingBy(a -> a));

        if(collect.keySet().size() == 1)
        {
            return 0;
        }
        final List<Pair<String, Integer>> collect1 = collect.entrySet().stream().map(e -> Pair.of(e.getKey(), e.getValue().size())).collect(Collectors.toList());

        final Pair<String, Integer> d = collect1.stream().max(pair -> Comparator.comparing(pair.getSecond())).orElse(Pair.of("d", 0));
        collect.remove(d.getFirst());

        return collect.values().stream().mapToInt(List::size).sum();

    }

    public static void main(String[] args) {
        //-6 , -91 1011 -100 84 -22 0 , 1 ,4, 7 , 3

        int[] a = {-6, -91, 1011, -100, 84,  -22, 0, 1, 4, 7, 3};
        //System.out.println(getValue(a));
        System.out.println(getValue1("<>>><"));
    }
}
