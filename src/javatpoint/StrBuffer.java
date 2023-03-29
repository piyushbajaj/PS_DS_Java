package javatpoint;

/**
 * Created by piyush.bajaj on 18/11/16.
 */
public class StrBuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello ");

        System.out.println(sb.capacity());

        //sb.append("Java");//now original string is changed
        System.out.println(sb);//prints Hello Java


        //sb.insert(1,"Java");//now original string is changed
        System.out.println(sb);//prints HJavaello

        //sb.replace(1, 3, "Java");
        System.out.println(sb);//prints HJavalo

        //sb.delete(1, 3);
        System.out.println(sb);//prints Hlo

        //sb.reverse();
        System.out.println(sb);//prints olleH

        /*
        The capacity() method of StringBuffer class returns the current capacity of the buffer.
        The default capacity of the buffer is 16. If the number of character increases from its current capacity,
        it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34.
         */

        System.out.println(sb.capacity());//default 22

        sb.append("java is my favourite language");
        System.out.println(sb.capacity());//now (22*2)+2=46 i.e (oldcapacity*2)+2


    }
}
