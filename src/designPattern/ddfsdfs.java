package designPattern;

interface TestA {
    String toString();
}

/**
 * Created by piyush.bajaj on 22/07/17.
 */
public class ddfsdfs {
    //static final int[] a = {100, 200};
    static int[] a;

    static void init() {
        a = new int[3];
        a[0] = 100;
        a[2] = 100;

        System.out.printf("Price:%8.2f", 10000.0 / 3.0);


    }

    public static void main(String[] args) {
        new ddfsdfs().message();
        System.out.println(new TestA() {
            @Override
            public String toString() {
                return "LinkedList.test";

            }
        });
    }

//    HashMap m1 = new HashMap();
//     ("map", "HashMap");
//    m1.put("schildt", "java2");
//    m1.put("mathew", "Hyden");
//    m1.put("schildt", "java2s");
//    print(m1.keySet());
//    print(m1.values());

    public void message() {
    }
};
