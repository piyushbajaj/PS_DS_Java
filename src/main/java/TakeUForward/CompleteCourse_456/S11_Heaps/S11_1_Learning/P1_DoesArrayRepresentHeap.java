package TakeUForward.CompleteCourse_456.S11_Heaps.S11_1_Learning;

/**
 * Created by bajajp on 27 Sep, 2022
 * Link: https://practice.geeksforgeeks.org/problems/does-array-represent-heap4345/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=does-array-represent-heap
 */
public class P1_DoesArrayRepresentHeap {

    /**
     * TC: O(N)
     *
     * @param arr
     * @param n
     * @return
     */
    static boolean countSub_MaxHeap(long[] arr, long n) {
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] < arr[2 * i + 1] || (2L * i + 2 < n && arr[i] < arr[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    static boolean countSub_MinHeap(long[] arr, long n) {
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] > arr[2 * i + 1] || (2L * i + 2 < n && arr[i] > arr[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long[] arrMaxHeap = {90, 15, 10, 7, 12, 2};
        System.out.println(countSub_MaxHeap(arrMaxHeap, arrMaxHeap.length));

        long[] arrMinHeap = {1, 2, 3, 4, 5, 6};
        System.out.println(countSub_MinHeap(arrMinHeap, arrMinHeap.length));
    }
}
