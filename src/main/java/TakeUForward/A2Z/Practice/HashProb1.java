package TakeUForward.A2Z.Practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: TakeUForward.A2Z.Practice
 * <p>
 * User: piyushbajaj
 * Date: 26/01/26
 * Time: 3:08 pm
 */
public class HashProb1 {
    public int mostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> hashResult = new HashMap<>();
        int maxFrequencyOfSameElement = 0;
        int smallestElementWithHighestFrequency = Integer.MAX_VALUE;

        for (int num : nums) {
            hashResult.put(num, hashResult.getOrDefault(num, 0) + 1);

            int currentElementFrequency = hashResult.get(num);
            if (currentElementFrequency >= maxFrequencyOfSameElement ) {
                maxFrequencyOfSameElement = currentElementFrequency;

                if (num <= smallestElementWithHighestFrequency) {
                    smallestElementWithHighestFrequency = num;
                }
            }
        }

        return smallestElementWithHighestFrequency;
    }

    public static void main(String[] args) {
        HashProb1 hashProb1 = new HashProb1();
        System.out.println(hashProb1.mostFrequentElement(new int[] {1, 2, 2, 3, 3, 3}));
    }
}
