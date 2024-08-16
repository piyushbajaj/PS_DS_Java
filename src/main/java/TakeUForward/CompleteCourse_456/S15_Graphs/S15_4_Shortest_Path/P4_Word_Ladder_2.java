package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 31/10/22
 * Time: 7:55 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/word-ladder-ii/1">...</a>
 */
public class P4_Word_Ladder_2 {

    public static void main(String[] args) {
        P4_Word_Ladder_2 p4_word_ladder_2 = new P4_Word_Ladder_2();
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};

        System.out.println(p4_word_ladder_2.findSequences("der", "dfs", wordList));

    }

    /**
     * Approach:
     * 1. We will keep usedStrings, tp keep track of the new strings occuring, which gets matched.
     * 2. Once the current list is done for all the possible words, then remove the queue top item.
     * 3. Once the word matches with target word, then add the current list into the result
     * 4. Keep removing item from the hash, the one which is present in used strings.
     * 5. Use queue for storing sequence of words, once it matches will add to the result.
     * TC:
     *
     * @param startWord
     * @param targetWord
     * @param wordList
     * @return
     */
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String str : wordList) {
            wordSet.add(str);
        }

        Queue<ArrayList<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Collections.singleton(startWord)));
        wordSet.remove(startWord);

        ArrayList<String> usedString = new ArrayList<>();
        usedString.add(startWord);
        int level = 0;

        while (!queue.isEmpty()) {
            ArrayList<String> currList = queue.peek();
            queue.poll();

            // Remove the strings from the hash, once you reach newer level
            if (currList.size() > level) {
                level++;
                for (String str : usedString) {
                    wordSet.remove(str);
                }
            }

            // Adding the currList to result only when word matches target word
            String word = currList.get(currList.size() - 1);
            if (word.equals(targetWord)) {
                if (result.size() == 0) {
                    result.add(currList);
                } else if (result.get(0).size() == currList.size()) {
                    result.add(currList);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordChar = word.toCharArray();
                    wordChar[i] = ch;
                    String newWord = new String(wordChar);

                    if (wordSet.contains(newWord)) {
                        currList.add(newWord);

                        ArrayList<String> temp = new ArrayList<>(currList);
                        queue.add(temp);
                        usedString.add(newWord);
                        currList.remove(currList.size() - 1);
                    }
                }
            }
        }
        return result;
    }
}
