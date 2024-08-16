package PracticeSessionMay2024.TwoPointer;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TwoPointer
 * <p>
 * User: piyushbajaj
 * Date: 29/06/24
 * Time: 9:31 am
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

/**
 * Question Link: <a href="https://leetcode.com/problems/sentence-similarity-iii/?envType=problem-list-v2&envId=e9snhf4h">...</a>
 */
public class P2_AreSentenceSimilar {

    /**
     * TC: O(N1 + N2)
     * SC: O(N1 + N2)
     *
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sen1 = sentence1.split(" ");
        String[] sen2 = sentence2.split(" ");

        int f1 = 0, f2 = 0, r1 = sen1.length - 1, r2 = sen2.length - 1;

        while (f1 <= r1 && f2 <= r2) {
            if (Objects.equals(sen1[f1], sen2[f2])) {
                f1++;
                f2++;
            } else if (Objects.equals(sen1[r1], sen2[r2])) {
                r1--;
                r2--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean areSentencesSimilar_Deque(String sentence1, String sentence2) {
        Deque<String> sen1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> sen2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));

        while (!sen1.isEmpty() && !sen2.isEmpty() && sen1.peek().equals(sen2.peek())) {
            sen1.poll();
            sen2.poll();
        }

        while (!sen1.isEmpty() && !sen2.isEmpty() && sen1.peekLast().equals(sen2.peekLast())) {
            sen1.pollLast();
            sen2.pollLast();
        }

        return sen1.isEmpty() || sen2.isEmpty();
    }

    public static void main(String[] args) {
        P2_AreSentenceSimilar p2AreSentenceSimilar = new P2_AreSentenceSimilar();
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println(p2AreSentenceSimilar.areSentencesSimilar(sentence1, sentence2));
        System.out.println(p2AreSentenceSimilar.areSentencesSimilar_Deque(sentence1, sentence2));

        String sen1 = "of";
        String sen2 = "A lot of words";
        System.out.println(p2AreSentenceSimilar.areSentencesSimilar(sen1, sen2));
        System.out.println(p2AreSentenceSimilar.areSentencesSimilar_Deque(sen1, sen2));
    }
}
