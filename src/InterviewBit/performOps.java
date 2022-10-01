package InterviewBit;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 07/04/17.
 */
public class performOps {
    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    public static void main(String[] args) {
        performOps per = new performOps();
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
//        B.se
//        //B.add(B.add(1), );
//        //B = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        per.performOps([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]);
    }
}
