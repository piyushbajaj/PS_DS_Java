package javatpoint;

/**
 * Created by piyush.bajaj on 14/03/16.
 */
public class Student {
    int id = 1;//data member (also instance variable)
    String name = "Piyush";//data member(also instance variable)

    public static void main(String args[]) {
        Student s1 = new Student();//creating an object of LinkedList.Student
        System.out.println(s1.id);
        System.out.println(s1.name);
    }

    public int getId() {
        return this.id;
    }
}
