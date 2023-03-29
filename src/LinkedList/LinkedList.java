package LinkedList;

public class LinkedList {
    ListNode Head;
    private int length = 0;

    //This class has a default constructor
    public LinkedList() {
        length = 0;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();


        linkedList.Head = new ListNode(1, null);

        //linkedList.Head = new LinkedList.ListNode(1);
        linkedList.InsertNodeBeg(new ListNode(2));
        linkedList.InsertNodeBeg(new ListNode(3));
        linkedList.InsertNodeBeg(new ListNode(4));
        linkedList.InsertNodeBeg(new ListNode(5));

        linkedList.InsertNode(-1, 3);


        //linkedList.remove(4);

        //linkedList.RemoveNodeFromHead();

        //linkedList.RemoveNodeFromEnd();


        //linkedList.RemoveNodeMatched(new LinkedList.ListNode(5));

        //linkedList.InsertNodeEnd(new LinkedList.ListNode(6));


        System.out.println("Head data :: " + linkedList.getHead().getNext().getNext().getNext().data);

        System.out.println("data :: " + linkedList.getHead().data);
        //linkedList.clearList();
        System.out.println("data :: " + linkedList.getHead().getNext().data);
        System.out.println("data :: " + linkedList.getHead().getNext().getNext().data);
        System.out.println("data :: " + linkedList.getHead().getNext().getNext().getNext().data);
        System.out.println("data :: " + linkedList.getHead().getNext().getNext().getNext().getNext().data);
        System.out.println("data :: " + linkedList.getHead().getNext().getNext().getNext().getNext().getNext().data);
        //System.out.println("data :: " + linkedList.getHead().getNext().getNext().getNext().getNext().getNext().data);

        System.out.println("All data :: " + linkedList.toString());

        System.out.println("Length of a list :: " + linkedList.length());

        System.out.println("Position of value 3 :: " + linkedList.getPosition(7));

        linkedList.clearList();

    }

    //Return the first node in the list
    public synchronized ListNode getHead() {
        return Head;
    }

    public ListNode gethead() {
        return Head;
    }

    //Insert the node at the beginning of the list
    public synchronized void InsertNodeBeg(ListNode node) {
        node.setNext(Head);
        Head = node;
        length++;
    }

    //Insert the node at the end of the list
    public synchronized void InsertNodeEnd(ListNode node) {
        if (Head == null) {
            Head = node;
        } else {
            ListNode p = Head;
            ListNode q = null;
                        /*for(p = Head; (q = p.getNext())!= null; p=q){
                                p.setNext(node);
                        }*/

            while ((q = p.getNext()) != null) {
                p.setNext(node);
                p = q;
            }
        }
        length++;
    }

    //Insert the node at any given position
    public synchronized void InsertNode(int data, int position) {
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }
        if (Head == null) {
            Head = new ListNode(data);
        }
        //adding data at the front of the list
        else if (position == 0) {
            ListNode temp = new ListNode(data);
            temp.next = Head;
            Head = temp;
        }

        //else find the correct position and insert
        else {
            ListNode temp = Head;
            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }

            ListNode t1 = temp.next;
            ListNode newnode = new ListNode(data);
//                        System.out.println("temp ::" + temp.data);
            temp.next = newnode;
            newnode.next = t1;
//                        newnode.next = temp.next;
//                        temp.setNext(newnode);
        }
        length += 1;
    }

    //Remove and return the node at the head of the list
    public synchronized ListNode RemoveNodeFromHead() {
        ListNode node = Head;
        if (node != null) {
            Head = node.getNext();
            node.setNext(null);
        }
        return node;
    }

    //Removing a matching node from the linked list

    //Remove and return the node at the end of the list
    public synchronized ListNode RemoveNodeFromEnd() {
        ListNode p = Head;
        ListNode q = null;
        ListNode next = Head.getNext();
        if (Head == null) {
            return null;
        }
        if (next == null) {
            Head = null;
            return p;
        }
        while ((next = p.getNext()) != null) {
            q = p;
            p = next;
        }
        q.setNext(null);
        return p;
    }

    //Remove the value at a given position

    public synchronized void RemoveNodeMatched(ListNode node) {
        if (Head == null) {
            return;
        } else if (node.equals(Head)) {
            Head = Head.getNext();
            return;
        } else {
            ListNode p = Head;
            ListNode q = null;
            while ((q = p.getNext()) != null) {
                if (node.equals(q.getNext())) {
                    p.setNext(q.getNext());
                    return;
                }
                p = q;
            }
        }
    }


    //Return a string representation of this collection, in the form ["str1", "str2",..]

    public void remove(int position) {
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length - 1;
        }
        if (Head == null) {
            return;
        }
        if (position == 0) {
            Head = Head.getNext();
        } else {
            ListNode temp = Head;
            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length -= 1;
    }

    //return the current length of the list

    public String toString() {
        String result = "[";
        if (Head == null) {
            return result + "]";
        }
        result = result + Head.getData();
        ListNode temp = Head.getNext();
        while (temp != null) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    //find the position for the particular value

    public int length() {
        return length;
    }

    //Remove everything from the list

    public int getPosition(int data) {
        ListNode temp = Head;
        int pos = 0;

        while (temp != null) {
            if ((temp.getData()) == data) {
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }
        return Integer.MIN_VALUE;
    }

    public void clearList() {
        Head = null;
        length = 0;
    }


//        public void
}
