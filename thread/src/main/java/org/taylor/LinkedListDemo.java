package org.taylor;

import java.util.*;
import java.util.LinkedList;

/**
 * @author taylor
 * @date 2019/12/24 9:55
 */
public class LinkedListDemo {


    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        int i = list.indexOf(3);
//        System.out.println(list.get(i - 1));
//        System.out.println(list.get(i + 1));

//        Map<String, String> map = new HashMap<>();
//        map.put("1","taylor");
//        map.put("2","nora");

        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(7);
        list.add(9);
        list.add(10);
        list.add(5);
        list.add(11);

        list.sort(Integer::compareTo);

        list.forEach(System.out::print);

    }
}
