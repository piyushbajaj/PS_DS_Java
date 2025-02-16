package Session.May2024.StriversA2ZSheet.Step1_LearnBasic.BasicMaths;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step1_LearnBasic.BasicMaths
 * <p>
 * User: piyushbajaj
 * Date: 08/09/24
 * Time: 9:31 am
 * <p>
 * Question: <a href="https://www.geeksforgeeks.org/problems/count-digits5716/1">...</a>
 * Striver: <a href="https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2">...</a>
 */
public class P1_CountDigits {
    public static int evenlyDivides(int N) {
        int count = 0;
        int temp = N;

        while (temp != 0) {
            int mod = temp % 10;
            if (mod != 0 && N % mod == 0) {
                count++;
            }

            temp = temp / 10;
        }
        return count;
    }

    public int countDigits(int N) {
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(evenlyDivides(12));
    }
}
