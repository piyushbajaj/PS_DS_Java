package Recursion;

/**
 * Created by piyush.bajaj on 30/03/16.
 */
public class A5 {
    void m(){
        System.out.println(this);
    }

    public static void main(String[] args) {
        A5 obj = new A5();
        System.out.println(obj);
        obj.m();
    }
}
