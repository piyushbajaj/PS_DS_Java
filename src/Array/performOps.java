package Array;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 12/05/17.
 */
public class performOps {

    ArrayList<Integer> performOps1(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }

    public static void main(String[] args) {
        performOps po = new performOps();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(10);
        arr.add(2);
        arr.add(1);

        ArrayList<Integer> B = po.performOps1(arr);
        for (int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i) + " ");
        }
    }
}
