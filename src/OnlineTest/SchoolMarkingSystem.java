package OnlineTest;

/**
 * Created by piyush.bajaj on 31/03/17.
 */
public class SchoolMarkingSystem {
    public static int marksForRank(int[] marks, int rank) {
        int n = marks.length;
        int max = 0, count = 0;

        for(int i = 0; i < n ; i++){
            if(marks[i] < 0)
                return -1;
            if(marks[i] > max)
                max = marks[i];
        }

        int[] cntMarks = new int[max+1];

        for(int i = 0; i <n; i++){
            cntMarks[marks[i]]++;
        }

        for(int i = max; i >=0; i--){
            if(cntMarks[i]!=0)
                count++;
            if(count == rank)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        SchoolMarkingSystem SM = new SchoolMarkingSystem();
        int a[] = {0, 0, 10, 10, 20, 20, 30, 10, 10, 40};
        System.out.print(marksForRank(a, 2));
    }
}
