package TakeUForward.S11_Heaps.S11_2_Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bajajp on 28 Sep, 2022
 *
 * Link: https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379?leftPanelTab=2
 */
public class P3_MergeKSortedList_MinHeap {

    static class Pair {
        // to store the value of arr
        int first;
        // to store ith index
        int second;
        // to store jth index
        int third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static class PairComparator implements Comparator<Pair> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.<p>
         * <p>
         * The implementor must ensure that <tt>sgn(compare(x, y)) ==
         * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>compare(x, y)</tt> must throw an exception if and only
         * if <tt>compare(y, x)</tt> throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
         * <tt>compare(x, z)&gt;0</tt>.<p>
         * <p>
         * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
         * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
         * <tt>z</tt>.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.first < o2.first)
                return -1;
            else if (o1.first > o2.first)
                return 1;
            else
                return 0;
        }
    }

    /**
     * Approach which involves min heap:
     * 1. Create a class Pair with first, second, third integers
     * 2. Create a comparator class, which would compare first integer in pairs
     * 3. Use this comparator as an argument to min heap
     *
     * @param arr
     * @param K
     * @return
     */
    public ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int rows = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(new PairComparator());

        // Add all the 0th column values to the min heap for comparison, the one with minimum will be on top
        for (int i = 0; i < rows; i++) {
            pairPriorityQueue.add(new Pair(arr[i][0], i, 0));
        }

        while (!pairPriorityQueue.isEmpty()) {
            Pair currentElement = pairPriorityQueue.remove();
            // Extract the minimum element only
            result.add(currentElement.first);

            int ithIndex = currentElement.second;
            int jthIndex = currentElement.third;

            // As a next step check if there exists next jth value in the same ith then add that value

            if (jthIndex + 1 < arr[ithIndex].length) {
                pairPriorityQueue.add(new Pair(arr[ithIndex][jthIndex + 1], ithIndex, jthIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P3_MergeKSortedList_MinHeap p3_mergeKSortedList_minHeap = new P3_MergeKSortedList_MinHeap();
        int k = 4;
        int[][] arr = {
                {1, 2, 3, 4},
                {2, 2, 3, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 9}};

        System.out.println(p3_mergeKSortedList_minHeap.mergeKArrays(arr, k));
    }
}
