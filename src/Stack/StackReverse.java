package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 18/09/16.
 *
 *
 Algorithm for calculating reverse of Stack:
 1. Create one stack recursive function reverse(Stack s)
 2. Do this operations inside this:
    a. if(!s.isEmpty){
    b. int temp = s.pop();
    c. call itself: reverse(s);
    d. call another function to insert these temp in the stack: reverse_utility(temp)
    e. } return s;
 3. reverse_utility(Stack s, int temp){
    a. if(s.isEmpty), then s.push(temp).
    b. else{
        Here we basically first taking out the all element and then inserting the called element.
        int top = s.pop();
        reverse_utility(s, temp);
        s.push(top);
 }
 */
public class StackReverse {
    public static void insertAtBottom(Stack<Integer> s,int data){
        int temp;
        if(s.isEmpty())
            s.push(data);
        else{


            temp = s.pop();
            insertAtBottom(s, data);

            s.push(temp);

        }



    }


    public static Stack reverse(Stack<Integer> s){
       if(!s.isEmpty()){
           int temp = s.pop();
           reverse(s);

           insertAtBottom(s, temp);


       }
        return s;
    }


    public void sortStack(Stack<Integer> s){
        int x, y;
        if(!s.isEmpty()){
            x = s.pop();
            y = s.pop();
        }
    }


    public static void main(String[] args) {
        StackReverse SR = new StackReverse();
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        //System.out.println(reverse(s));
        System.out.println(SR.reverse_stack(s));

        //System.out.println(insertAtBottom(s));


        //reverse(s);

    }

    //int temp = 0;
    public Stack reverse_stack(Stack<Integer> s){
        if(!s.isEmpty()) {
            int temp = s.pop();
            reverse_stack(s);
            reverse_utility(s, temp);
        }



        return s;
    }

    public void reverse_utility(Stack<Integer> s, int tmp){
        if(s.isEmpty())
        {
            s.push(tmp);
            return;
        }
        else {
            int top = s.pop();
            reverse_utility(s, tmp);
            s.push(top);
        }
    }
}
