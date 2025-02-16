package Session.May2024.TwoPointer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TwoPointer
 * <p>
 * User: piyushbajaj
 * Date: 01/07/24
 * Time: 9:22 pm
 */
public class Trial {

    public static void test(String sentence1, String sentence2) {
        Deque<String> sen1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> sen2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));

        System.out.println(sen1.peek());
        System.out.println(sen1.peekFirst());
        System.out.println(sen1.peekLast());
    }


    public static void main(String[] args) {
        Deque<Integer> sen1 = new ArrayDeque<>();
        sen1.add(1);
        sen1.add(2);
//        sen1.push(3);

        System.out.println(sen1.peek());
        System.out.println(sen1.peekFirst());
        System.out.println(sen1.peekLast());

        test("How are you", "How");
    }
}
