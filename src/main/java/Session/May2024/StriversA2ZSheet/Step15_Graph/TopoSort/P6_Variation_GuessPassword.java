package Session.May2024.StriversA2ZSheet.Step15_Graph.TopoSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step15_Graph.TopoSort
 * <p>
 * User: piyushbajaj
 * Date: 26/07/24
 * Time: 8:00 pm
 */
public class P6_Variation_GuessPassword {

    public String guessThePassword(String[] words) {

        // create out-degree adjacency map, which stores character along with its linkage
        Map<Character, List<Character>> adjacencyMap = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adjacencyMap.put(ch, new ArrayList<>());
            }
        }

        // stores all the out-degrees
        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            int firstWordLen = firstWord.length();
            String secondWord = words[i + 1];
            int secondWordLen = secondWord.length();

            for (int j = 0; j < Math.min(firstWordLen, secondWordLen); j++) {
                if (firstWord.charAt(j) != secondWord.charAt(j)) {
                    adjacencyMap.get(firstWord.charAt(j)).add(secondWord.charAt(j));
                    break;
                }
            }
        }

        // do the topological sort
        Map<Character, Boolean> isVisited = new HashMap<>();
        Stack<Character> output = new Stack<>();

        // go through each unique character from adjacency list
        for (char ch : adjacencyMap.keySet()) {
            boolean flag = dfs(adjacencyMap, ch, isVisited, output);

            if (!flag) {
                return "";
            }
        }

        StringBuilder result = new StringBuilder();

        while (!output.isEmpty()) {
            result.append(output.pop());
        }


        return result.toString();
    }

    private boolean dfs(Map<Character, List<Character>> adjacencyMap, char curr, Map<Character, Boolean> isVisited,
                        Stack<Character> output) {
        if (isVisited.containsKey(curr)) {
            return isVisited.get(curr);
        }

        // entry with false denotes that this node is visited. But once all the outgoing nodes have been fully
        // explored, this will be turned to true. Also helps in detecting cycles in the DAG
        isVisited.put(curr, false);

        // go through all adjacent nodes
        for (char adjacentChar : adjacencyMap.get(curr)) {
            boolean flag = dfs(adjacencyMap, adjacentChar, isVisited, output);

            if (!flag) {
                return false;
            }
        }

        isVisited.put(curr, true);
        output.push(curr);

        return true;

    }

    public static void main(String[] args) {
        P6_Variation_GuessPassword p6VariationGuessPassword = new P6_Variation_GuessPassword();
//        String[] words = {"z", "x", "z"};

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(p6VariationGuessPassword.guessThePassword(words));
    }
}
