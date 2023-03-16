package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.Arrays;
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
 * Time: 5:18 pm
 * <p>
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/word-ladder/">...</a>
 */
public class P3_Word_Ladder_1 {

    static class Pair {
        String word;
        int length;

        Pair(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    /**
     * Approach:
     * 1. Store all the words into the hashset
     * 2. Keep checking all characters and the one that matches, push that into queue
     * 3. Once it gets the target word, then return
     * TC: O(N) + O(N)*O(K)*26
     * SC: O(N)
     *
     * @param startWord
     * @param targetWord
     * @param wordList
     * @return
     */
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> words = new HashSet<>();

        words.addAll(Arrays.asList(wordList));

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));
        words.remove(startWord);

        while (!queue.isEmpty()) {
            String currWord = queue.peek().word;
            int currLen = queue.peek().length;
            queue.poll();

            if (currWord.equals(targetWord)) {
                return currLen;
            }

            for (int i = 0; i < currWord.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] currWordToChar = currWord.toCharArray();
                    currWordToChar[i] = j;
                    String newWord = new String(currWordToChar);

                    if (words.contains(newWord)) {
                        words.remove(newWord);
                        queue.add(new Pair(newWord, currLen + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        P3_Word_Ladder_1 p3_word_ladder_1 = new P3_Word_Ladder_1();
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        System.out.println(p3_word_ladder_1.wordLadderLength("der", "dfs", wordList));
    }
}
