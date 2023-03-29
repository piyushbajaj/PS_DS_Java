package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 18/09/16.
 */
public class StackThreeTest {

    public static boolean checkBalance(char c[]) {
        Stack<Character> s = new Stack<>();
        int count = 0;


        for (char ch : c) {
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
                count++;
            } else if (ch == ')') {
                if (s.peek() == '(') {
                    s.pop();
                    count--;
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (s.peek() == '{') {
                    s.pop();
                    count--;
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (s.peek() == '[') {
                    s.pop();
                    count--;
                } else {
                    return false;
                }
            } else {
                System.exit(1);
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printNGE(int[] arr) {
        int size = arr.length;
        //int[] a = new int[size];
        int a[] = {-1, -1, -1, -1};

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] < arr[j]) {
                    a[i] = arr[j];
                    break;
                }
            }
            System.out.println(a[i]);
        }


    }

    public static void main(String[] args) {

        String s = "[()]";
        char[] i = s.toCharArray();
        System.out.println(checkBalance(i));

        int arr[] = {4, 5, 2, 25};
        printNGE(arr);

    }
}
