package Crack_Interview_2022.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bajajp on 13 Aug, 2022
 */
public class ListListSort {
    public static void sortList(List<List<Integer>> list) {
//        list.sort(new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> l1, List<Integer> l2) {
//                return l1.get(0).compareTo(l2.get(0));
//            }
//        });

        list.sort((a, b) -> a.get(0) - b.get(0));
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 6),
                Arrays.asList(8, 10),
                Arrays.asList(15, 18));

        sortList(list);

        System.out.println(list);
    }
}
