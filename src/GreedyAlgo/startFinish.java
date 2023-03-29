package GreedyAlgo;

/**
 * Created by piyush.bajaj on 22/02/17.
 */
public class startFinish {
    public static void main(String[] args) {
        startFinish sf = new startFinish();
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        sf.startFinishTime(start, end);
    }

    public void startFinishTime(int[] start, int[] end) {
        int n = start.length;
        int i = 0;
        System.out.print(i + " ");

        int j = 0;
        for (i = 1; i < n; i++) {
            if (start[i] >= end[j]) {
                System.out.print(i + " ");
                j++;
            }
        }
    }
}
