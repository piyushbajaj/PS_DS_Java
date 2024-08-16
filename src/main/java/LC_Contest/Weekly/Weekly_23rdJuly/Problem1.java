package LC_Contest.Weekly.Weekly_23rdJuly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: LC_Contest.Weekly.Weekly_23rdJuly
 * <p>
 * User: piyushbajaj
 * Date: 23/07/23
 * Time: 8:11 am
 * <p>
 * Split Strings by Separator
 * <p>
 * Given an array of strings words and a character separator, split each string in words by separator.
 * <p>
 * Return an array of strings containing the new strings formed after the splits, excluding empty strings.
 * <p>
 * Notes
 * <p>
 * separator is used to determine where the split should occur, but it is not included as part of the resulting strings.
 * A split may result in more than two strings.
 * The resulting strings must maintain the same order as they were initially given.
 */
public class Problem1 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.contains(String.valueOf(separator))) {
                String sep = "\\".concat(String.valueOf(separator));
                System.out.println("Word: " + word);
                List<String> subResult = new ArrayList<>(List.of(word.split(sep)));
                System.out.println("Word: " + subResult);
                subResult.removeAll(Arrays.asList("", null));
                result.addAll(subResult);
            } else {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();

        List<String> words = new ArrayList<>(Arrays.asList("one.two.three", "four.five", "six"));
        char separator = '.';
        System.out.println(problem1.splitWordsBySeparator(words, separator));

        List<String> words1 = new ArrayList<>(Arrays.asList("$easy$", "$problem$"));
        char separator1 = '$';
        System.out.println(problem1.splitWordsBySeparator(words1, separator1));

        List<String> words2 = new ArrayList<>(Arrays.asList("|||"));
        char separator2 = '|';
        System.out.println(problem1.splitWordsBySeparator(words1, separator1));
    }
}
