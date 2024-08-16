package Javatpoint;

/**
 * Created by piyush.bajaj on 26/11/16.
 */

interface Printable1 {
    void print();
}

interface Showable1 extends Printable1 {
    void show();
}

public class inheritance_demo implements Showable1 {
    public static void main(String args[]) {
        inheritance_demo obj = new inheritance_demo();
        obj.print();
        obj.show();
    }

    public void print() {
        System.out.println("Hello");
    }

    public void show() {
        System.out.println("Welcome");
    }
}
