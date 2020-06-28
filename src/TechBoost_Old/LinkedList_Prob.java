package TechBoost_Old;

import java.util.HashSet;

/**
 * Created by piyush.bajaj on 10/03/18.
 */
public class LinkedList_Prob {
    Node head;
    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void createLinkList(int x){
        Node p = new Node(x);
        if(head == null){
            head = p;
            return;
        }

        Node curr = head;
        while (curr.next!=null){
            curr = curr.next;
        }

        curr.next = p;

    }

    public void printList(Node p){
        while (p!=null){
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.print(" NULL");
        System.out.println();
    }

    public Node LLInsertBefore(int x){
        Node p = new Node(x);
        if(head == null) {
            head = p;
            return head;
        }

        p.next = head;
        head = p;
        return head;
    }

    public Node LLInsertLast(int x){
        Node p = new Node(x);

        if(head == null){
            head = p;
            return head;
        }

        Node q = head;
        while (q.next!=null){
            q = q.next;
        }
        q.next = p;
        return head;
    }

    public Node LLDeleteBefore(){
        if(head == null)
            return null;

        head = head.next;
        return head;
    }

    public Node LLDeleteNode(Node p){
        if(head == null || p == null)
            return null;

        if(p.next == null) {
            p = null;
            return p;
        }

        p.data = p.next.data;
        p.next = p.next.next;

        return head;

    }

    boolean isCircular(Node node){
        if(head == null )
            return false;

        Node p = node;
        while (p.next!=null && p.next!=node){
            p = p.next;
        }

        if(p.next == node) return true;
        else return false;
    }

    boolean isLoop_hash(Node node){
        if(head == null )
            return false;

        HashSet<Node> hashSet = new HashSet<>();
        while (node!=null){
            if(hashSet.contains(node))
                return true;
            hashSet.add(node);
            node = node.next;
        }
        return false;
    }

    boolean isLoop_pointer(Node node){
        if(head == null )
            return false;

        Node slow_ptr = node;
        Node fast_pts = node;
        while (fast_pts.next!=null){
            slow_ptr = slow_ptr.next;
            fast_pts = fast_pts.next.next;
            if(slow_ptr==fast_pts){
                return true;
            }
        }
        return false;
    }

    Node isLoop_pointer_startNode(Node node){
        if(head == null )
            return null;

        Node slow_ptr = node;
        Node fast_pts = node;
        while (fast_pts.next!=null){
            slow_ptr = slow_ptr.next;
            fast_pts = fast_pts.next.next;
            if(slow_ptr==fast_pts){
                break;
            }
        }


        slow_ptr = node;
        while (fast_pts.next!=null){
            if(slow_ptr == fast_pts)
                return slow_ptr;
            slow_ptr = slow_ptr.next;
            fast_pts = fast_pts.next;
        }
        return null;
    }

    public Node reverseLL(){
        if(head == null) return null;

        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (next!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;

        }
        curr.next = prev;
        head = curr;
        return head;
    }

    public void print_reverse(Node key){
        if(key == null) {
            //System.out.print("NULL");
            return;
        }


        if(key!=null)
            print_reverse(key.next);

        System.out.print(key.data + " -> ");
    }

    public static void main(String[] args) {
        LinkedList_Prob ll = new LinkedList_Prob();
        ll.createLinkList(1);
        ll.createLinkList(2);
        ll.createLinkList(3);
        ll.createLinkList(4);
        ll.createLinkList(5);

        //ll.head.next.next.next.next = ll.head;
//        ll.printList(ll.head);
//
//        ll.LLInsertBefore(10);
//        ll.printList(ll.head);
//
//        ll.LLDeleteBefore();
//        ll.printList(ll.head);
//
//        ll.LLInsertLast(50);
//        ll.printList(ll.head);
//
//        ll.LLDeleteNode(ll.head.next.next);
//        ll.printList(ll.head);

//        System.out.println(ll.isCircular(ll.head));
//
//        System.out.println(ll.isLoop_hash(ll.head));
//
//        System.out.println(ll.isLoop_pointer(ll.head));


        ll.createLinkList(6);
        ll.createLinkList(7);
        ll.createLinkList(8);
        ll.createLinkList(9);

        ll.printList(ll.head);
        System.out.println("Printing Linked List in reverse order: ");
        ll.print_reverse(ll.head);
        System.out.println();
//        ll.head.next.next.next.next.next.next.next.next = ll.head.next.next;
//
//        System.out.println(ll.isLoop_pointer(ll.head));
//
//        System.out.println(ll.isLoop_pointer_startNode(ll.head).data);

        ll.reverseLL();
        ll.printList(ll.head);

    }
}
