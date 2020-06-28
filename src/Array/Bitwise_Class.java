package Array;

/**
 * Created by piyush.bajaj on 11/12/16.
 */
public class Bitwise_Class {

    /*
    As per syntax of bitshift operator, left hand side of operand is the number whose bit needs to be shift and
    right hand side of operator is how many bits needs to shift
     */

    //Bitwise unary complement operator (~) Example

    public void BitwiseUnaryComplement(int number){

        //example of bitwise unary complement operator (~)
        System.out.println(" value of number before: " + number);
        System.out.println(" value of number after negation: " + ~number);
    }


    //Bitwise AND operator (&) Example

    public void BitwiseAndComplement(int a, int b){

        //example of bitwise unary complement operator (~)
        System.out.println(" value of number before: " + a + " " +b);
        System.out.println(" value of number after Bitwise AND Complement: " + (a&b));
    }

    //Bitwise OR operator (|) Example
    public void BitwiseORComplement(int a, int b){

        //example of bitwise unary complement operator (~)
        System.out.println(" value of number before: " + a + " " +b);
        System.out.println(" value of number after Bitwise OR Complement: " + (a|b));
    }

    //Bitwise XOR operator (^) Example
    /*
    Bitwise XOR operators will return 1 if both bits are different and return 0 if both bits are same.
     */

    public void BitwiseXORComplement(int a, int b){

        //example of bitwise unary complement operator (~)
        System.out.println(" value of number before: " + a + " " +b);
        System.out.println(" value of number after Bitwise XOR Complement: " + (a^b));
    }

    //Bitwise Left Shift Operator
    public void BitwiseLeftShift(int number){

        System.out.println(" value of number before: " + number);
        System.out.println(" value of number after Bitwise Left Shift: " + (number << 1));
    }

    //Bitwise Right Shift Operator
    public void BitwiseRightShift(int number){

        System.out.println(" value of number before: " + number);
        System.out.println(" value of number after Bitwise Right Shift: " + (number >> 2));
    }

    //Unsigned Right Shift Operator
    public void BitwiseUnsignedRightShift(int number){

        System.out.println(" value of number before: " + number);
        System.out.println(" value of number after Bitwise Unsigned Right Shift: " + (number >>> 1));
    }

    public static void main(String[] args) {

        Bitwise_Class BC = new Bitwise_Class();
        BC.BitwiseUnaryComplement(2);
        BC.BitwiseAndComplement(2, 10);
        BC.BitwiseORComplement(2, 4);
        BC.BitwiseXORComplement(2, 4);
        BC.BitwiseLeftShift(8);
        BC.BitwiseRightShift(8);
        BC.BitwiseUnsignedRightShift(8);


    }
}
