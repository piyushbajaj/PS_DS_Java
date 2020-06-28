package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 07/12/16.
 */
import java.util.*;

public class Demo {
    public static void main(String[] args) {

        // create a LinkedList.LinkedList
        LinkedList list = new LinkedList();



        // add some elements
        list.add("Hello");
        list.add(2);
        list.add("Chocolate");
        list.add("10");

        // print the list
        System.out.println("LinkedList.LinkedList:" + list);

        // retrieve and remove the head of the list
        System.out.println("Head element of the list:" + list.pop());

        // print the list
        System.out.println("LinkedList.LinkedList:" + list);
    }
}
