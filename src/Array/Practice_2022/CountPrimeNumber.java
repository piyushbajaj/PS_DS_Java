package Array.Practice_2022;

/**
 * Project: DS_Algo
 * Package: Array.Practice_2022
 * <p>
 * User: piyushbajaj
 * Date: 25/03/23
 * Time: 11:43 pm
 */
public class CountPrimeNumber {

    static int totalPrime = 0;
    private static final int MAX_INT = 100000000;

    public boolean checkPrime(int x) {
        for (int i = 2; i <= (int) Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeNumber(int x) {
        int count = 0;
        for (int i = 2; i <= x; i++) {
            if (checkPrime(i)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountPrimeNumber countPrimeNumber = new CountPrimeNumber();

        System.out.println(countPrimeNumber.countPrimeNumber(100));
    }
}
