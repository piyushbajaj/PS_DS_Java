package Flipkart_test;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 11/06/18.
 */
public class Main_Class {
    public static void main(String[] args) {

        String[] people = {"a", "b", "c"};
        String[] emailId = {"a@xyz.com", "b@xyz.com", "c@xyz.com"};

        Person person = new Person();
        person.addPerson(people, emailId);
        System.out.print(person.hashMapPerson);

        String[] groupId = {"G1", "G2"};
        ArrayList<String> group_list1 = new ArrayList<String>();
        group_list1.add("a");
        group_list1.add("b");

        ArrayList<String> group_list2 = new ArrayList<String>();
        group_list2.add("b");
        group_list2.add("c");

        Group group = new Group();
        group.addPersonToGroup("G1", group_list1);
        group.addPersonToGroup("G2", group_list2);

        Bill bill = new Bill();


        //bill.addBill("G1", );


    }
}
