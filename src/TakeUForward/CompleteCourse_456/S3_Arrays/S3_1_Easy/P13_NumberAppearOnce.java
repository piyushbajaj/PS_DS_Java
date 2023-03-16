package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_1_Easy
 * <p>
 * User: piyushbajaj
 * Date: 20/11/22
 * Time: 8:18 pm
 */
public class P13_NumberAppearOnce {
    public int singleNumber(int[] nums) {
        int a = 0;

        for (Integer num : nums) {
            a = a ^ num;
        }

        return a;
    }

    public static void main(String[] args) {
        P13_NumberAppearOnce p13_numberAppearOnce = new P13_NumberAppearOnce();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(p13_numberAppearOnce.singleNumber(nums));
    }
}
