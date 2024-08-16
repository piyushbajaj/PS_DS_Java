package PracticeSessionMay2024.StriversA2ZSheet.Step15_Graph.TopoSort;

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
 * Time: 5:47 pm
 * <p>
 * Steps:
 * 1. Create Adjacency Map, which will hold each letter and their edges
 * 2. Create isVisited boolean Map, which will hold letter along-with boolean flag
 * 3. Add all letters into the adjacencyMapList, and initialize the arraylist
 * 4. Start comparing two words next to each other, and insert the letters, which is the first mismatch into the
 * adjacencyMapList corresponding to that node.
 */
public class P6_AlienDictionary {

    /**
     * TC: O(N) -> Total length of all the words
     * SC: O(Unique Chars)
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {

        // This will maintain out-degree edges
        Map<Character, List<Character>> adjacencyMapList = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adjacencyMapList.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];
            int firstWordLen = words[i].length();
            int secondWordLen = words[i + 1].length();

            if (firstWord.length() > secondWord.length() && firstWord.startsWith(secondWord)) {
                return "";
            }

            for (int j = 0; j < Math.min(firstWordLen, secondWordLen); j++) {
                if (firstWord.charAt(j) != secondWord.charAt(j)) {
                    adjacencyMapList.get(firstWord.charAt(j)).add(secondWord.charAt(j));
                    break;
                }
            }
        }

        // now the adjacency map already contains letter along-with list, its time for topological sort
        Map<Character, Boolean> isVisited = new HashMap<>();
        Stack<Character> output = new Stack<>();
        boolean result;

        for (char uniqueChar : adjacencyMapList.keySet()) {
//            if (!isVisited.containsKey(uniqueChar)) {
            result = dfs(adjacencyMapList, isVisited, uniqueChar, output);
            if (!result) {
                return "";
            }
//            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!output.isEmpty()) {
            stringBuilder.append(output.pop());
        }

        return stringBuilder.toString();
    }

    private boolean dfs(Map<Character, List<Character>> adjacencyMapList, Map<Character, Boolean> isVisited,
                        char uniqueChar, Stack<Character> output) {
        if (isVisited.containsKey(uniqueChar)) {
            return isVisited.get(uniqueChar);
        }

        isVisited.put(uniqueChar, false);

        boolean flag;
        for (char adjacentChar : adjacencyMapList.get(uniqueChar)) {
//            if (!isVisited.containsKey(adjacentChar)) {
            flag = dfs(adjacencyMapList, isVisited, adjacentChar, output);
            if (!flag) {
                return false;
            }
//            }
        }

        isVisited.put(uniqueChar, true);
        output.push(uniqueChar);

        return true;
    }

    public static void main(String[] args) {
        P6_AlienDictionary p6AlienDictionary = new P6_AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(p6AlienDictionary.alienOrder(words));

        String[] words1 = {"z", "x", "z"};
        System.out.println(p6AlienDictionary.alienOrder(words1));

        String[] words2 = {"bca", "bcd", "cad"};
        System.out.println(p6AlienDictionary.alienOrder(words2));
    }
}
