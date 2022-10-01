package CrackingCoding.LinkedList.Jan_2018;

import java.util.HashSet;

/**
 * Created by piyush.bajaj on 26/01/18.
 */
public class removeDuplicates {
    static Node head;
    static class Node{
        Node next;
        char data;

        Node(char data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node createLL(String s){
        int n = s.length();
        if(n == 0) return null;

        Node Nd = head;
        for(int i = 0; i < n; i++){
            if(Nd == null){
                Nd = new Node(s.charAt(i));
                head = Nd;
            }
            else {
                Nd.next = new Node(s.charAt(i));
                Nd = Nd.next;
            }
        }

        return head;
    }

    public static void printList(Node Nd){
        if(head == null)
            return;

        while (Nd!=null){
            System.out.print(Nd.data + " -> ");
            Nd = Nd.next;
        }

        System.out.print("NULL");
    }

    public static void main(String[] args) {
        String str = "FOLLOWUP";
        head = createLL(str);

        printList(head);

        //head = LinkedList.removeDuplicates(head);

        head = removeDuplicates_1(head);

        System.out.println();

        printList(head);
    }

    //Using HashMap
    /*
    Time Complexity: O(N)
    Space COmplexity: O(N)

     */
    public static Node removeDuplicates(Node head){
        HashSet<Character> hashSet = new HashSet<>();

        Node Nd = head;
        if(Nd == null)
            return Nd;

        while (Nd.next!=null){
            if(hashSet.contains(Nd.next.data)){
                Nd.next = Nd.next.next;
            }
            else{
                hashSet.add(Nd.next.data);
                Nd = Nd.next;
            }

        }

        return head;
    }

    /*
    Compromising Time Complexity: O(N*N)
    Space: O(1)
     */
    public static Node removeDuplicates_1(Node head){
        //HashSet<Character> hashSet = new HashSet<>();

        Node Nd = head;
        if(Nd == null)
            return Nd;

        while (Nd!=null){
            Node temp = Nd;
            while (temp!=null && temp.next!=null){
                if(Nd.data == temp.next.data){
                    temp.next = temp.next.next;
                }
                else
                    temp = temp.next;
            }
            Nd = Nd.next;

        }

        return head;
    }

}
