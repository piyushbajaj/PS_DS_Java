package CompanyWise.Foray;

/**
 * Project: DS_Algo
 * Package: CompanyWise.Foray
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 6:42 pm
 * <p>
 * link: <a href="https://www.geeksforgeeks.org/program-print-palindromes-given-range/">...</a>
 */
public class CheckIfNumberPalindrome {
    static int isPalindrome(int n) {

        // Find reverse of n
        int rev = 0;
        for (int i = n; i > 0; i /= 10) {
            rev = rev * 10 + i % 10;
        }

        // If n and rev are same,
        // then n is palindrome
        return (n == rev) ? 1 : 0;
    }

    // prints palindrome between
    // min and max
    static void countPal(int min, int max) {
        for (int i = min; i <= max; i++) {
            if (isPalindrome(i) == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        countPal(100, 2000);
    }
}
