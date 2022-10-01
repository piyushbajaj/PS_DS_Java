package Array.Practice_2022.TwoPointers;

/**
 * Created by bajajp on 10 Sep, 2022
 */
public class P7_TrappingRainWater {
    public int trappingWater(int[] height) {
        int ans = 0;
        int n = height.length - 1;

        for (int i = 0; i < n; i++) {
            int left_max = 0;
            int right_max = 0;

            for (int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }

            for (int j = i; j < n; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            ans += Math.min(left_max, right_max) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        P7_TrappingRainWater p7_trappingRainWater = new P7_TrappingRainWater();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(p7_trappingRainWater.trappingWater(arr));
    }
}
