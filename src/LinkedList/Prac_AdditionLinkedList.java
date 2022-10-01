package LinkedList;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 13/03/17.
 */
public class Prac_AdditionLinkedList {
    Node head, tail;

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node createLinkedList(int[] arr){
        if(head!=null)
            head = null;

        for(int i = 0; i < arr.length; i++){
            appendNode(arr[i]);
        }

        return head;
    }

    public void appendNode(int value){
        if(head == null){
            head = new Node(value);
            tail = head;
        }

        else {
            Node temp = new Node(value);
            tail.next = temp;
            tail = temp;
        }
    }

    public void printList(Node Nd){
        while (Nd!=null){
            System.out.print(Nd.data + "->");
            Nd = Nd.next;
        }
        System.out.print(" NULL");
        System.out.println();
    }

    public int getCount(Node Nd){
        int count = 0;
        while (Nd!=null){
            count++;
            Nd = Nd.next;
        }
        return count;
    }

    public int diffInNodes(Node head1, Node head2){
        return  getCount(head1) - getCount(head2);
    }

    public Node addingLinkList(Node head1, Node head2){
        if(head1 == null && head2 == null){
            System.out.println("There are no nodes");
            return null;
        }

        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        int[] carry = new int[1];
        Node result;

        int diff = diffInNodes(head1, head2);

        if(diff > 0)
            result =  addingLinkList(head1, null, diff - 1, carry, head1, head2 );
        else if(diff < 0)
            result = addingLinkList(null, head2, diff + 1, carry, head1, head2 );
        else {
            result = addingLinkList(head1, head2, diffInNodes(head1, head2), carry, head1, head2);
        }

        if(carry[0]!=0){
            Node temp = new Node(carry[0]);
            temp.next = result;
            result = temp;
        }
        return result;

    }

    public Node addingLinkList(Node Nd1, Node Nd2, int diff, int[] carry, Node head1, Node head2){
        Node nextNode;

        if(Nd1 == null && Nd2 == null)
            return null;

        if(diff > 0){
            nextNode = addingLinkList(Nd1.next, null, diff-1, carry, head1, head2);
        }
        else if(diff < 0){
            nextNode = addingLinkList(null, Nd2.next, diff+1, carry, head1, head2);
        }
        else {
            Node node1 = (Nd1==null)? head1: Nd1.next;
            Node node2 = (Nd2==null)? head2: Nd2.next;

            nextNode = addingLinkList(node1, node2, 0, carry, head1, head2);

        }

        int val1 = (Nd1!=null)?Nd1.data: 0;
        int val2 = (Nd2!=null)?Nd2.data: 0;

        int sum = (val1 + val2 + carry[0])%10;
        carry[0] = (val1 + val2 + carry[0])/10;

        Node currentNode = new Node(sum);
        currentNode.next = nextNode;


        return currentNode;
    }

    public Node addingLinkList_UsingStack(Node head1, Node head2){
        Node Nd1 = head1;
        Node Nd2 = head2;

        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();

        Stack<Integer> stk3 = new Stack<>();

        while (Nd1!=null){
            stk1.push(Nd1.data);
            Nd1 = Nd1.next;
        }

        while (Nd2!=null){
            stk2.push(Nd2.data);
            Nd2 = Nd2.next;
        }

        int sum;
        int carry = 0;
        int val = 0;
        while (!stk1.isEmpty() && !stk2.isEmpty()){
            val = (stk1.pop() + stk2.pop() + carry);
            sum = val%10;
            carry = val/10;

            stk3.push(sum);
        }

        while (!stk1.isEmpty()){
            val = (stk1.pop() + carry);
            sum = val%10;
            carry = val/10;
            stk3.push(sum);
        }

        while (!stk2.isEmpty()){
            val = (stk2.pop() + carry);
            sum = val%10;
            carry = val/10;
            stk3.push(sum);
        }

        int[] arr = new int[stk3.size()];

        int i = 0;
        while (!stk3.isEmpty()){
            arr[i++] = stk3.pop();
        }

        Node result = createLinkedList(arr);

        return result;


    }


    public static void main(String[] args) {
        Prac_AdditionLinkedList PA = new Prac_AdditionLinkedList();

        int[] firstNumber  = {9,8,9,7,6}; // number: 98976
        int[] secondNumber = {1,9,8}; // number: 198

        Node head1 = PA.createLinkedList(firstNumber);
        PA.printList(head1);

        Node head2 = PA.createLinkedList(secondNumber);
        PA.printList(head2);

        Node result = PA.addingLinkList(head1, head2);
        PA.printList(result);

        Node res = PA.addingLinkList_UsingStack(head1, head2);
        PA.printList(res);

    }
}
