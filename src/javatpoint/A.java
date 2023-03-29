package javatpoint;

/**
 * Created by piyush.bajaj on 25/02/17.
 */
public interface A {
    void a();

    void b();

    void c();

    void d();
}


abstract class B implements A {
    public void c() {
        System.out.println("I am C");
    }
}

class M extends B {
    public void a() {
        System.out.println("I am a");
    }

    public void b() {
        System.out.println("I am b");
    }

    public void d() {
        System.out.println("I am d");
    }
}

class Test5 {
    public static void main(String args[]) {
        M a = new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }
}