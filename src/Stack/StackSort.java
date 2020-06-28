package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 19/09/16.
 *

 We can use below algorithm to sort stack elements:
 1. It almost same like reverse stack logic. So here first of all will have recursive function sort_stack(Stack s)
 2. Which will have these condition:
    a. if(!s.isEmpty){
    b. int temp = s.pop();
    c. sort_stack(s);
    d. sort_stack_util(s, temp); // This calls another recursive function.
    }
 3. Lets define this recursive function sort_stack_util(Stack s, int temp){
    a. if(s.isEmpty), then s.push(temp);
    b. else{
    c. if(temp < s.peek()){
            int top = s.pop();
            sort_stack_util(s, temp);
            s.push(top)
            }
        else{
        s.push(temp)
            }
        }
    }

 Time Complexity: O(n)
 */
public class StackSort {






    public static void sortAStack(Stack<Integer> s){
        int temp=0;
        if(!s.isEmpty()){
            temp = s.pop();
            sortAStack(s);
            sortedInsert(s, temp);

        }
    }

    //Below algorithm is to insert element is sorted order:
    public static void sortedInsert(Stack<Integer> s, int data){
        int temp =0;
        if(s.isEmpty() || data > s.peek())
            s.push(data);
        else{
            temp = s.pop();
            sortedInsert(s, data);
            s.push(temp);
        }
    }

    public static void displayStack(Stack<Integer> s){
        if(!s.isEmpty()){
            System.out.println(s.pop());
            displayStack(s);
        }
    }

    public static void main(String[] args) {
        StackSort stk = new StackSort();
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        displayStack(s);
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
//        System.out.println("Element on the top: " + s.peek());
//        sortAStack(s);
//        System.out.println("Element on the top: " + s.peek());
//        displayStack(s);

        System.out.println(stk.sort_stack(s));
        System.out.println(s.peek());

    }

    public Stack<Integer> sort_stack(Stack<Integer> s){
        if(!s.isEmpty()){
            int temp = s.pop();
            sort_stack(s);
            sort_stack_util(s, temp);
        }
        return s;
    }

    public void sort_stack_util(Stack<Integer> s, int temp){
        if(s.isEmpty())
            s.push(temp);
        else {
            if(temp < s.peek()){
                int top = s.pop();
                sort_stack_util(s, temp);
                s.push(top);
            }
            else
                s.push(temp);
        }
    }


}
