package Session.StriverA2Z.Arrays_1;

/**
 * Project: DSAlgo
 * Package: Session.StriverA2Z.Arrays_1
 * <p>
 * User: piyushbajaj
 * Date: 22/03/25
 * Time: 5:13 pm
 * <p>
 * Link: <a href="https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/">...</a>
 */
public class P2_SecondLargestElement {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int val : arr) {
            if (val > largest) {
                secondLargest = largest;
                largest = val;
            } else if (val > secondLargest && val != largest) {
                secondLargest = val;
            }
        }

        return secondLargest;
    }

    public int getSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int val : arr) {
            if (val < smallest) {
                secondSmallest = smallest;
                smallest = val;
            } else if (val < secondSmallest && val != smallest) {
                secondSmallest = val;
            }
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        P2_SecondLargestElement p2SecondLargestElement = new P2_SecondLargestElement();
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(p2SecondLargestElement.getSecondLargest(arr));
        System.out.println(p2SecondLargestElement.getSecondSmallest(arr));

        int[] arr1 = {10, 5, 10};
        System.out.println(p2SecondLargestElement.getSecondLargest(arr1));
    }
}
