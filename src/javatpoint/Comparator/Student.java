package javatpoint.Comparator;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by piyush.bajaj on 19/04/18.
 */
public class Student {
    int rollNo;
    String name, address;

    public Student(int rollNo, String name, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.rollNo + " ," + this.name + " ," + this.address;
    }
}

class SortByRollNo implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return a.rollNo - b.rollNo;
    }
}

class SortByName implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }

        ar.sort(new SortByName());
        System.out.println("Sorted by Name");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }

        ar.sort(new SortByRollNo());
        System.out.println("Sorted by Roll No");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }
    }
}
