package TechboostJune2020.DoublyLinkedList;

public class AdditionOfNodes {

    Node head;

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    //Adding a Node in Front
    public void addingNodeInFront (int data) {
        Node newNode = new Node(data);

        //Good Practice to write both next & prev node
        newNode.next = head;
        newNode.prev = null; //Could be ignored

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    //Adding Node after a given Node
    public void addingNodeAfterGivenNode (Node nodePrev, int data) {
        //NULL check
        if(nodePrev == null)
            return;

        Node newNode = new Node(data);

        newNode.next = nodePrev.next;
        nodePrev.next = newNode;
        newNode.prev = nodePrev;

        if(newNode.next!=null){
            newNode.next.prev = newNode;
        }

        return;
    }

    //Adding node in the end
    public void addingNodeInTheEnd (int data) {
        Node newNode = new Node(data);

        Node end = head;
        //Null check
        if(head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (end.next != null) {
            end = end.next;
        }

        end.next = newNode;
        newNode.prev = end;
    }

    //Adding Node before a given Node
    //Assignment!
    public void insertNodeBefore(Node nodeNext, int data) {

    }


}