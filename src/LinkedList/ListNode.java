package LinkedList;

/**
 * Created by piyush.bajaj on 02/04/16.
 * Declaration of a Linked List
 */
public class ListNode {
    public int data;
    public ListNode next;

//    public LinkedList.ListNode(ia){
//        this.data=data;
//    }

    public ListNode(int data){
        this.data=data;
    }

    public ListNode(int data, ListNode next){
        this.data = data;
        this.next=next;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
//        this.next = null;
        return this.next;
    }

    //ListLength takes linked list as an input and counts the number of nodes in the list

    public int ListLength(ListNode headNode){
        int length = 0;
        ListNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode.getNext();
        }

        return length;
    }



//    public static void main(String[] args) {
//        LinkedList.ListNode ln = new LinkedList.ListNode();
//       // LinkedList.ListNode ln_next = new LinkedList.ListNode();
//        ln.setData(5);
//        System.out.print(ln.getData() + "->");
//        ln.setData(10);
//        System.out.println(ln.getData());
//        ln.setNext(ln);
//        //ln_next = ln;
//        System.out.println("Next Address:" + ln);
//        System.out.println("Length of Linked List:" + ln.ListLength(ln));
//    }
}

