package Array.LC.Easy;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {

    public static ArrayList twoSumUtil(Integer[] input, Integer target) {
        Integer[] sortedArr = (Integer[]) Arrays.stream(input).sorted().toArray();
        for(int i = 0; i < input.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 7, 11, 15};
        Integer target = 9;
        System.out.println(twoSumUtil(arr, target));
    }
}
