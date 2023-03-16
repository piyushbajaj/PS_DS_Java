package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 26/10/22
 * Time: 5:26 pm
 * <p>
 */
public class P5_Course_Schedule_I {

    public int[] findOrder(int N, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        int[] resultArr = new int[N];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.size(); i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        int[] indegree = new int[N];

        // Populate indegree
        for (int i = 0; i < N; i++) {
            for (Integer adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }

        // Insert all the nodes with Indegree 0 into queue
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Check Acyclic using Topo Sort
        while (!queue.isEmpty()) {
            int currElement = queue.poll();
            topo.add(currElement);

            for (Integer adjNode : adj.get(currElement)) {
                if (indegree[adjNode] > 0) {
                    indegree[adjNode]--;
                }

                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }

        int k = 0;
        for (Integer i : topo) {
            resultArr[k++] = i;
        }

        return topo.size() == N ? resultArr : new int[] {};
    }

    public boolean isPossible(int N, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[N];

        // Populate indegree
        for (int i = 0; i < N; i++) {
            for (Integer adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }

        // Insert all the nodes with Indegree 0 into queue
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Check Acyclic using Topo Sort
        while (!queue.isEmpty()) {
            int currElement = queue.poll();
            topo.add(currElement);

            for (Integer adjNode : adj.get(currElement)) {
                if (indegree[adjNode] > 0) {
                    indegree[adjNode]--;
                }

                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }

        return topo.size() == N;

    }

    public static void main(String[] args) {
        P5_Course_Schedule_I p5_course_schedule_i = new P5_Course_Schedule_I();
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        System.out.println(p5_course_schedule_i.isPossible(4, prerequisites));

//        ArrayList<ArrayList<Integer>> prequisiteList = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//            prequisiteList.add(new ArrayList<>(prerequisites[i]));
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            prequisiteList.get(prerequisites[i][0]).add(prerequisites[i][1]);
//        }
//
//        System.out.println(Arrays.toString(p5_course_schedule_i.findOrder(4, 4, prequisiteList)));
    }
}
