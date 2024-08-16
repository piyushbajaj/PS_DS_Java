package Array;

/**
 * Created by piyush.bajaj on 16/01/17.
 */
public class findMedian {

    public static void main(String[] args) {
        findMedian FM = new findMedian();
        int[] arr1 = {1, 12, 15, 26, 38, 40};
        //int[] arr1 = {1, 3};
        int[] arr2 = {2, 13, 17, 30, 45, 46};
        //int[] arr2 = {5, 7};

        int n = arr1.length;

        FM.findMedian_evenNum(arr1, arr2, n);
        System.out.println("Original Array: ");

        FM.printArray(arr1);
        FM.printArray(arr2);
        //System.out.println("Median of both the Array is: ");
        //System.out.println(FM.findMedian_evenNum(arr1, arr2, n));

        System.out.println("Median of both the Array over much improved time complexity: ");
        System.out.println(FM.findMedian_improved(arr1, 0, n - 1, arr2, 0, n - 1));

    }

    //With time complexity: O(n)
    public int findMedian_evenNum(int[] arr1, int[] arr2, int n) {
        int count = 0;
        int m1 = -1, m2 = -1, i = 0, j = 0;
        for (count = 0; count <= n; count++) {
            //In the case where 1st array elements are smaller than 2nd array
            if (i == n) {
                m1 = m2;
                m2 = arr2[0];
                break;
            } else if (j == n) {
                m1 = m2;
                m2 = arr1[0];
                break;
            }

            if (arr1[i] < arr2[j]) {
                m1 = m2;
                m2 = arr1[i];
                i++;
            } else {
                m1 = m2;
                m2 = arr2[j];
                j++;
            }


        }
        return (m1 + m2) / 2;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int findMedian_improved(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2) {
        int len = e1 - s1 + 1;

        if (len == 0) {
            return -1;
        } else if (len == 1) {
            return (arr1[s1] + arr2[s2]) / 2;
        } else if (len == 2) {
            return (Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2])) / 2;
        } else {
            ///Now first get median
            int m1 = getMedian(arr1, s1, e1);
            int m2 = getMedian(arr2, s2, e2);

            if (m1 == m2) {
                return m1;
            } else if (m1 < m2) {
                if (len % 2 == 0) {
                    return findMedian_improved(arr1, s1 + len / 2, e1, arr2, s2, s2 + (len / 2 - 1));
                }
                return findMedian_improved(arr1, s1 + len / 2, e1, arr2, s2, s2 + len / 2);
            } else {
                if (len % 2 == 0) {
                    return findMedian_improved(arr1, s1, s1 + (len / 2 - 1), arr2, s2 + len / 2, e2);
                }
                return findMedian_improved(arr1, s1, s1 + (len / 2), arr2, s2 + len / 2, e2);
            }
        }
    }

    public int getMedian(int[] arr, int s, int e) {
        int len = e - s + 1;
        if (len % 2 == 0) {
            return (arr[s + len / 2] + arr[s + (len / 2 - 1)]) / 2;
        }
        return (arr[s + len / 2]);
    }
}
