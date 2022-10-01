package Crack_Interview_2022.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by bajajp on 04 Aug, 2022
 */
public class Learning_PriorityQueue {
    private static void testStringsNaturalOrdering() {
        Queue<String> testStringsPQ = new PriorityQueue<>();
        testStringsPQ.add("abcd");
        testStringsPQ.add("1234");
        testStringsPQ.add("23bc");
        testStringsPQ.add("zzxx");
        testStringsPQ.add("abxy");

        System.out.println("Strings Stored in Natural Ordering in a Priority Queue\n");
        while (!testStringsPQ.isEmpty()) {
            System.out.println(testStringsPQ.poll());
        }
    }

    private static void testStringsDecreasingOrder() {
        Queue<Integer> testIntegersPQ = new PriorityQueue<>(new CustomIntegerComparator_DecreasingOrder());
        testIntegersPQ.add(11);
        testIntegersPQ.add(5);
        testIntegersPQ.add(-1);
        testIntegersPQ.add(12);
        testIntegersPQ.add(6);

        System.out.println("Integers stored in reverse order of priority in a Priority Queue\n");
        while (!testIntegersPQ.isEmpty()) {
            System.out.println(testIntegersPQ.poll());
        }
    }

    public static void main(String[] args) {
        testStringsNaturalOrdering();
        testStringsDecreasingOrder();
    }
}
