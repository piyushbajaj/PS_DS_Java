package Array;

/**
 * Created by piyush.bajaj on 21/10/16.
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4, 3, 3, 3};
        me.majorElement(a);

        int cand = me.majorityElement(a);
        System.out.println("Is the majority of an element: " + cand +
            " occurred more than half of the number of elements: " + me.isMajor(a, cand));
    }

    public void majorElement(int[] a) {
        //This taken n^2 time
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
                if (count >= a.length / 2) {
                    System.out.println("Majority of an element is: " + a[i]);
                    return;
                }
            }
        }
    }

    public int majorityElement(int[] a) {
        int major = 0;
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[major] == a[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                major = i;
                count = 1;
            }


        }
        return a[major];
    }

    public boolean isMajor(int[] a, int cand) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == cand) {
                count++;
            }
        }

        if (count > a.length / 2) {
            return true;
        } else {
            return false;
        }
    }
}
