package Array;

/**
 * Created by piyush.bajaj on 13/02/17.
 */
public class swappingTwoNumbers {
    //Without using temp variable

    public static void main(String[] args) {
        swappingTwoNumbers sw = new swappingTwoNumbers();
        sw.withoutTemp('k', 'o');
    }

    public void withoutTemp(char a, char b) {
        a = ((char) (a ^ b));
        b = ((char) (a ^ b));
        a = ((char) (a ^ b));

        System.out.println("After swapping the numbers a:" + a + " b: " + b);
    }
}
