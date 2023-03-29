package Javatpoint;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 18/11/16.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        System.out.println("Initial size of al: " + al.size());

        al.add("a");
        al.add("b");
        al.add("c");
        al.add("d");
        al.add("e");
        al.add("f");
        al.add(1, "a2");

        System.out.println("Size of al after additions: " + al.size());

        System.out.println("Contents of al: " + al);

        al.remove("f");
        al.remove(2);
        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);
    }
}
