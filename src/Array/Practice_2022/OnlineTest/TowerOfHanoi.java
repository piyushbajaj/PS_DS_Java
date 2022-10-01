package Array.Practice_2022.OnlineTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by bajajp on 22 May, 2022
 */
public class TowerOfHanoi {
    static class MyComparator implements Comparator {

        public int compare(Object obj1, Object obj2) {

            Integer i1 = (Integer) obj1;

            Integer i2 = (Integer) obj2;

            return i2.compareTo(i1);

        }

    }

    public static ArrayList<Integer>[] solve(int[] A) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int n = A.length;
        int max = A.length;

        Queue<Integer> queue = new PriorityQueue<Integer>(new MyComparator());

//        int[] disks = new int[n];

        for (int j : A) {
            queue.add(j);

            while (!queue.isEmpty() && queue.peek() == max) {
                arrayList.add(queue.poll());
                System.out.print(queue.poll() + " ");
                max--;
            }

            System.out.println();
        }


        return null;

    }

    public static void main(String[] args) {
        int[] A = {4, 5, 1, 2, 3};
        solve(A);
    }
}
