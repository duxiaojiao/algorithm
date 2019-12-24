package org.taylor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author taylor
 * @date 2019/12/24 9:55
 */
public class LinkedListDemo {


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int i = list.indexOf(3);
        System.out.println(list.get(i - 1));
        System.out.println(list.get(i + 1));

    }
}
