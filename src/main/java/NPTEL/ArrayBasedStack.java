//package NPTEL;
//
//import java.util.Stack;
//
///**
// * Created by piyush.bajaj on 26/10/16.
// */
//public class ArrayBasedStack implements Stack{
//    //Implementation of the stack interface using an array
//
//    public static final int CAPACITY = 1024;        //Default capacity of stack
//
//    private int N;      //Maximum capacity of the stack
//
//    private Object S[];     //S holds the elements of the stack
//
//    private int t = -1;     //the top element of the stack
//
//    public ArrayBasedStack()    //Initialize the stack with default capacity
//    {this(CAPACITY);}
//
//    public ArrayBasedStack(int cap)     //Initialize the stack with given capacity
//    {N=cap; S= new Object[N];}
//
//    public int size()                   //Return the current stack size
//    {return (t+1);}
//
//    public boolean isEmpty()            //Return true if the stack is empty
//    {return (t<0);}
//
////    public void push(Object obj) throws StackFullException {
////        //Push a new element on the stack
////
////        if (size() == N)
////            throw new StackFullException("Stack Overflow");
////        S[++t] = obj;
////    }
////
////    public Object top() throws StackEmptyException {
////        //Return the top stack element
////
////        if(isEmpty())
////            throw new StackEmptyException("Stack is empty");
////        return S[t];
////    }
////
////    public Object pop() throws StackEmptyException {
////        //Pop Off the stack element
////
////        Object elem;
////        if(isEmpty()) {
////            throw new StackEmptyException("Stack is empty");
////        }
////        elem = S[t];
////        S[t--] = null;      //Dereference S[top] and decrement top
////        return elem;
////    }
//
//}
//
//
//
//
//}
