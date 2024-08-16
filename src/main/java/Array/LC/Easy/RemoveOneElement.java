package Array.LC.Easy;

/**
 * Created by bajajp on 31 Jul, 2022
 */
public class RemoveOneElement {
    public static void main(String[] args) {
        RemoveOneElement removeOneElement = new RemoveOneElement();
        System.out.println(removeOneElement.removeOneElement(new int[] {1, 2, 10, 5, 7}));
    }

    public boolean removeOneElement(int[] nums) {
        int len = nums.length;
        int[] cal = new int[len - 1];
        if (isSorted(nums)) {
            return true;
        }

        for (int i = 0; i < len - 1; i++) {
            System.arraycopy(nums, i + 1, cal, i, len - i - 1);
            if (isSorted(cal)) {
                return true;
            }
        }

        return false;
    }

    public boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }

        return true;
    }
}
