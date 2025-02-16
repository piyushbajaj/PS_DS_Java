package Session.Uber;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: Session.Uber
 * <p>
 * User: piyushbajaj
 * Date: 13/02/25
 * Time: 11:06 am
 * Link: <a href="https://leetcode.com/problems/bus-routes/">...</a>
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 * <p>
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 * <p>
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 */
public class BusStops {

    /**
     * 1. Get the maximum bus stop present, so we can construct array with that length
     * 2. Create minBusTransition array with size: maxBusStop+1
     * 3. Fill the array with maxBus + 1 and keep the source at 0
     * 4. Iterate through each routes one by one get the minimum bus needed, then keep updating that for each bus stops
     * <p>
     * TC: O(Number of routes * Routes Length)
     * SC: O(Largest Bus Stop + 1)
     *
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int maxBuses = routes.length;
        int maxBusStop = -1;
        boolean flagSource = false;
        boolean flagTarget = false;
        for (int[] route : routes) {
            for (int stop : route) {
                maxBusStop = Math.max(maxBusStop, stop);

                if (stop == source) {
                    flagSource = true;
                }
                if (stop == target) {
                    flagTarget = true;
                }
            }
        }

        if (maxBusStop < target || !flagSource || !flagTarget) {
            return -1;
        }

        int[] minBusTransition = new int[maxBusStop + 1];
        Arrays.fill(minBusTransition, maxBuses + 1);
        minBusTransition[source] = 0;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int[] route : routes) {
                int minBus = maxBuses + 1;
                for (int stop : route) {
                    minBus = Math.min(minBus, minBusTransition[stop]);
                }
                minBus++;
                for (int stop : route) {
                    if (minBusTransition[stop] > minBus) {
                        minBusTransition[stop] = minBus;
                        flag = true;
                    }
                }
            }
        }

        return minBusTransition[target] == maxBuses + 1 ? -1 : minBusTransition[target];
    }

    public static void main(String[] args) {
        BusStops busStops = new BusStops();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(busStops.numBusesToDestination(routes, 1, 6));
    }
}
