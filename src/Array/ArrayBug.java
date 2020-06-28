package Array;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 12/05/17.
 */
public class ArrayBug {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size() - B; i++) {


            ret.add(A.get(i + B));
        }
        for(int i = 0; i < B; i++){
            ret.add(A.get(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayBug AB = new ArrayBug();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.print(AB.rotateArray(arr, 1));
    }
}
