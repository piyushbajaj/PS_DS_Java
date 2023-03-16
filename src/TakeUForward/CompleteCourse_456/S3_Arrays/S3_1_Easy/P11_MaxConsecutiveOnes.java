package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_1_Easy
 * <p>
 * User: piyushbajaj
 * Date: 20/11/22
 * Time: 7:23 pm
 */
public class P11_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currMax = 0;
        int maxSoFar = 0;

        for (Integer num : nums) {
            if (num == 1) {
                currMax++;
                maxSoFar = Math.max(currMax, maxSoFar);
            } else {
                currMax = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        P11_MaxConsecutiveOnes p11_maxConsecutiveOnes = new P11_MaxConsecutiveOnes();

        int[] arr = {1, 1, 0, 1, 1, 1};

        System.out.println(p11_maxConsecutiveOnes.findMaxConsecutiveOnes(arr));
    }
}
