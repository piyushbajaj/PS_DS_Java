package CrackingCoding;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 24/02/18.
 */
public class test {
    int i = 1;

    {
        i = 2;
    }

    {
        i = 4;
    }

    test() {
        i = 3;
    }

    test(int i) {
        this.i = i;
    }

    static void doIt(int x, int y, int m) {
        if (x == 5) {
            m = y;
        } else {
            m = x;
        }


    }

    static int[] rearrange(int[] elements) {
        int n = elements.length;

        int[] result = new int[n];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(elements[i]);
            int strlen = s.length();

            int count = 0;
            for (int j = 0; j < strlen; j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
            hashMap.put(elements[i], count);
        }

        List list = new LinkedList(hashMap.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                    .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        int i = 0;
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
            result[i++] = (int) entry.getKey();
        }
        //return sortedHashMap;


        return result;
    }

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        Stack<Character> stack = new Stack<>();

        //StringBuffer stringBuffer = new StringBuffer();
        boolean flag = true;
        int[] result = new int[expressions.length];

        for (int i = 0; i < expressions.length; i++) {
            for (int j = 0; j < expressions[i].length(); j++) {
                if (expressions[i].charAt(j) == '<') {
                    stack.push('<');
                } else if (expressions[i].charAt(j) == '>') {
                    if (!stack.isEmpty() && stack.peek() == '<') {
                        stack.pop();
                    } else if (maxReplacements[i] > 0) {
                        maxReplacements[i]--;
                        continue;
                        //stringBuffer.append('>');
                    } else if (maxReplacements[i] <= 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] expressions = {"<>>>", "<>>>>"};
        int[] maxReplacements = {2, 2};
        balancedOrNot(expressions, maxReplacements);
//        int[] elements = {14, 5, 3, 7, 10, 5};
//        rearrange(elements);
//
//        int n = elements.length;
//        for(int i = 0; i < n; i++)
//            System.out.println(elements[i]);
//        int i = 6, j = 4, k = 9;
//        LinkedList.test.doIt(i, j, k);
//        System.out.println(k);
//
//        new LinkedList.test().print();
//        new LinkedList.test(5).print();
//
//        String s1=new String("Hello");
//        String s2=new String("there");
//        String s3=new String();
//
//        //s1.getChar
//
//        int i;
//
//
//        int x = new Integer(20);
//        //s3 = s1 & s2;
//
//        System.out.println(s3);
//
//        System.out.println();
//
//        try{
//            badMethod();
//            System.out.print("A");
//
//        }
//
//        catch (Exception ex){
//            System.out.print("B");
//            throw new IllegalArgumentException("piyush" + "rathore");
//        }
//
//        finally {
//            System.out.print("C");
//        }
//
//        System.out.print("D");

//        final Collection<? extends Number> foo = new ArrayList<Number>();
//
//
//
//int i = 1;
//        if(i++ == --i ){
//            System.out.println("0");
//        }
//        else
//            System.out.println("1");
//
//        String s = "abcdefgh";
//        int stringLength = s.length();
//        char chars[] = new char[stringLength];
//        s.getChars(0, stringLength, chars, 0);
//        //CharArrayReader reader1 = newCharArrayReader(c);
//        //CharArrayReader reader2 = newCharArrayReader(c, 1, 4);
//        //int i;
//        //int j;
////        try {
////            while ((i = reader1.read()) == (j = reader2.read())) {
////                System.out.print((char) i);
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
    }


    //java.util.List ints = new java.util.List<Integer>();

    public static void badMethod() {

    }

    public void print() {
        System.out.print(i);
    }

//    static volatile Map<String, String> m;


}


