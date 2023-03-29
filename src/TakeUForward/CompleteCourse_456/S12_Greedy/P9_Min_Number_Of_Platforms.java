package TakeUForward.CompleteCourse_456.S12_Greedy;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S12_Greedy
 * <p>
 * User: piyushbajaj
 * Date: 19/10/22
 * Time: 4:21 pm
 * <p>
 */
public class P9_Min_Number_Of_Platforms {
    public static void main(String[] args) {
        P9_Min_Number_Of_Platforms p9_min_number_of_platforms = new P9_Min_Number_Of_Platforms();
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(p9_min_number_of_platforms.findPlatform(arr, dep, 6));
    }

    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    public int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int countPlatform = 1;
        int minPlatform = 0;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                countPlatform++;
                i++;
            } else {
                countPlatform--;
                j++;
            }

            if (countPlatform > minPlatform) {
                minPlatform = countPlatform;
            }
        }

        return minPlatform;

    }
}
