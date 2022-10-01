package javatpoint;

/**
 * Created by piyush.bajaj on 18/11/16.
 * Performance LinkedList.test of String and StringBuffer
 */
public class PerformanceTest {
    public static String concatWithString(){
        String t = "Java";
        for(int i = 0; i < 10000; i++){
            t = t+ "TPoint";
        }
        return t;
    }

    public static String concatWithStringBuffer(){
        StringBuffer sb = new StringBuffer("Java");
        for(int i = 0; i < 10000; i++) {
            sb.append("TPoint");
        }
        return sb.toString();
    }

    public static String concatWithStringBuilder(){
        StringBuilder sb = new StringBuilder("Java");
        for(int i = 0; i < 10000; i++) {
            sb.append("TPoint");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //concatWithStringBuffer();
//        concatWithString();
//        System.out.println("Time taken by concatenating by String only: " + (System.currentTimeMillis() - startTime) + "ms");
//        startTime = System.currentTimeMillis();
        concatWithStringBuffer();
        //concatWithString();
        System.out.println("Time taken by concatenating by String Buffer now: " +
                (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        concatWithStringBuilder();
        System.out.println("Time taken by concatenating by String Builder now: " +
                (System.currentTimeMillis() - startTime) + "ms");
    }
}
