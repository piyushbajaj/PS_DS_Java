package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 29/10/22
 * Time: 6:09 pm
 * <p>
 */
public class P7_Alien_Dictionary {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoSort = topoSort(K, adjList);
        StringBuilder ans = new StringBuilder();

        for (Integer i : topoSort) {
            ans.append((char) (i + (int) 'a'));
        }

        return ans.toString();
    }

    public List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        Queue<Integer> storeElement = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                inDegree[adjNode]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                storeElement.add(i);
            }
        }
        while (!storeElement.isEmpty()) {
            int currElement = storeElement.peek();
            storeElement.poll();
            result.add(currElement);

            for (Integer adjNode : adj.get(currElement)) {
                if (inDegree[adjNode] != 0) {
                    inDegree[adjNode]--;
                }

                if (inDegree[adjNode] == 0) {
                    storeElement.add(adjNode);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P7_Alien_Dictionary p7_alien_dictionary = new P7_Alien_Dictionary();

        String[] dict = {"ajcdkalclhkalklkaffagc",
            "baehilhiadeeleggaddedfakelf",
            "bajeiicifhlaghjdjjkakfddelckhkkbiag",
            "didehekfdiibac",
            "edfkkfjfcacchaiblgbfikhekldejfkfabhbbhbkicfkeadlg",
            "ejjldh",
            "flaebkkkaikkebijhllbbalagaje",
            "ghjbckhidg",
            "jljee"};

        System.out.println(p7_alien_dictionary.findOrder(dict, 9, 12));
    }
}
