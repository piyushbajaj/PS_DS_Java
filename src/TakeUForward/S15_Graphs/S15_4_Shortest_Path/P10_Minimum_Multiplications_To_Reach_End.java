package TakeUForward.S15_Graphs.S15_4_Shortest_Path;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 03/11/22
 * Time: 1:40 pm
 * <p>
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1">...</a>
 */
public class P10_Minimum_Multiplications_To_Reach_End {
    static class Pair {
        int steps, num;

        Pair(int steps, int num) {
            this.steps = steps;
            this.num = num;
        }
    }

    /**
     * We can use Dijkstras here, with the variation that instead of priority we can use normal queue as the steps
     * are getting incremented +1 only
     * TC: O(10^5 * N)
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> queue = new LinkedList<>();
        int[] dist = new int[100000];

        for (int i = 0; i < 100000; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        queue.add(new Pair(0, start));

        while (!queue.isEmpty()) {
            int currStep = queue.peek().steps;
            int currNum = queue.peek().num;
            queue.poll();

            if (currNum == end) {
                return currStep;
            }

            for (Integer it : arr) {
                int temp = currNum * it;

                if (temp > 100000) {
                    temp = temp % 100000;
                }

                if (currStep + 1 < dist[temp]) {
                    queue.add(new Pair(currStep + 1, temp));
                    dist[temp] = currStep + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P10_Minimum_Multiplications_To_Reach_End p10_minimum_multiplications_to_reach_end =
            new P10_Minimum_Multiplications_To_Reach_End();
        int arr[] = {2, 5, 7};

        System.out.println(p10_minimum_multiplications_to_reach_end.minimumMultiplications(arr, 3, 30));
    }
}
