package TakeUForward.CompleteCourse_456.S4_Binary_Search.S4_1_Learning;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S4_Binary_Search.S4_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 11:28 am
 * <p>
 */
public class P2_Find_Floor {
    public static void main(String[] args) {
        P2_Find_Floor p2_find_floor = new P2_Find_Floor();
        long[] arr = {1, 2, 8, 10, 11, 12, 19};


        System.out.println(p2_find_floor.findFloor(arr, arr.length, 3));
    }

    public int findFloor(long[] arr, int n, long x) {
        int start = 0;
        int end = n - 1;
        int floor = -1, ceil = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                floor = mid;
                start = mid + 1;
            } else {
                ceil = mid;
                end = mid - 1;
            }
        }

        return floor;
    }
}
