package Recursion;

/**
 * Created by piyush.bajaj on 27/03/16.
 */
public class Student8 {
    int id;
    String name;

    Student8(){
        System.out.println("Default cons is invoked");
    }

    Student8(int id, String name){
        this();
        this.id = id;
        this.name = name;
    }

    void display(){
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        Student8 s1 = new Student8(1, "Piyush");
        Student8 s2 = new Student8(2, "Harsh");
        s1.display();
        s2.display();
    }

}
