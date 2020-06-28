package CodingQuestions;

/**
 * Created by piyush.bajaj on 30/11/16.
 */
public class MultiplyTwoStrings {
    public static String multiply(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int n3 = n1*n2;
        String str = Integer.toString(n3);

        return str;
    }


    public static void main(String[] args) {
        int t = 2;
        int[] num1 = new int[t];
        int[] num2 = new int[t];


        //System.out.println("Number of LinkedList.test case: " + t);
        for(int i=0; i < t; i++){
            num1[i] = 33;
            num2[i] = 2;
            System.out.println(multiply(Integer.toString(num1[i]), Integer.toString(num2[i])));
            i++;
            num1[i] = 11;
            num2[i] = 23;
            System.out.println(multiply(Integer.toString(num1[i]), Integer.toString(num2[i])));
        }


    }
}
