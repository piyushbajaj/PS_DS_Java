package Array.Practice_2022.OnlineTest;

/**
 * Created by bajajp on 22 May, 2022
 */
public class PositiveDiffIndex {
    public static int findDiff(int[] A) {
        int n = A.length;
        int maxCount = 0;

//        for (int i = 0; i < n; i++) {
//
//        }
//
//        int maxCount = 0;
//        int i = 0, count = 0, j = 0;
//        while (i < n) {
//            if (A[i])
//        }

//        int i = 0, j = n - 1;
//
//        while (i < j) {
//            if (A[i] < A[j]) {
//                maxCount = Math.max(maxCount, j - i + 1);
//                j--;
//            } else {
//                i++;
//            }
//        }


        int min = A[0], max = A[0], minIndex = 0, maxIndex = 0;
        int maximumIndex = 0;
        for (int i = 0; i < A.length; i++) {
            min = A[i];
            minIndex = i;
            boolean isMaxPresent = false;
            for (int j = i; j < A.length; j++) {
                if (A[j] > min) {
                    max = A[j];
                    maxIndex = j;
                    isMaxPresent = true;
                }
            }
            if (maximumIndex < ((maxIndex - minIndex) + 1)) {
                maximumIndex = (maxIndex - minIndex) + 1;
            }
        }
        return maximumIndex;

//        return maxCount;

//        for (int i = 0; i < n; i++) {
//
//            for (int j = i + 1; j < n; j++) {
//                if (A[i] < A[j]) {
//
//                }
//            }
//        }
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 2, 1, 2};
        int[] arr = {5, 3, 2, 1, 1, 4};
        System.out.println(findDiff(arr));

    }
}
