package CompanyWise.Foray;

/**
 * Project: OnlineTest
 * Package: TechnicalRound
 * <p>
 * User: piyushbajaj
 * Date: 08/03/23
 * Time: 9:40 am
 */
public class Add_Big_Number {

    public static String addBigNumbers(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        StringBuilder result = new StringBuilder();

        int i = n1 - 1, j = n2 - 1;

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum =
                carry + (int) (s1.charAt(i) - '0') + (int) (s2.charAt(j) - '0');
            carry = sum / 10;
            sum = sum % 10;
            result.append(sum);
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = carry + (int) (s1.charAt(i) - '0');
            carry = sum / 10;
            sum = sum % 10;
            result.append(sum);
            i--;
            j--;
        }

        while (j >= 0) {
            int sum = carry + (int) (s2.charAt(j) - '0');
            carry = sum / 10;
            sum = sum % 10;
            result.append(sum);
            i--;
            j--;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return reverseStr(result.toString());
    }


    public static String reverseStr(String str) {
        int start = 0, end = str.length() - 1;
        char[] charArray = str.toCharArray();

        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(addBigNumbers("12", "123"));

        System.out.println(addBigNumbers("13343543564565744334235457567567", "86865497568678656e54756756756865"));

//        System.out.println(Arrays.toString("123".toCharArray()));
    }
}
