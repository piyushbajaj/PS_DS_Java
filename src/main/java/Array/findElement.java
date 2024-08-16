package Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by piyush.bajaj on 08/02/17.
 */
public class findElement {

    public static void main(String[] args) {
        findElement FE = new findElement();
        String[] programming = new String[] {"Java", "C++", "Perl", "Lisp"};

        FE.findAnElement(programming);
    }

    public void findAnElement(String[] str) {

        //Checking an string in string array by converting to an Array List
        List<String> programmingList = Arrays.asList(str);

        boolean result = programmingList.contains("Java");

        System.out.println("Does programming Array contains Java? " + result);

        int index = programmingList.indexOf("Java");

        System.out.println("Index of Java in programming array is: " + index);

    }
}
