package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 21/09/17.
 */
public class BT_Doubly_LL {
    Node root;
    Node head;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

//    static class LNode{
//        LNode next;
//        LNode prev;
//        int data;
//
//        LNode(int data){
//            this.data = data;
//            this.next = this.prev = null;
//        }
//    }

    BT_Doubly_LL(){
        root = null;
    }

    BT_Doubly_LL(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }


    //Time Complexity: O(n*n)
    public Node convert_to_DLL(Node key){
        if(key == null)
            return null;


        if(key.left!=null) {
            Node prev = convert_to_DLL(key.left);


            //Getting InOrder Successor of Node
            while (prev.right!=null)
                prev = prev.right;

            prev.right = key;
            key.left = prev;
        }

        if(key.right!=null){
            Node next = convert_to_DLL(key.right);

            //Getting InOrder Predecessor of Node
            while (next.left!=null)
                next = next.left;

            next.left = key;
            key.right = next;

        }

        return key;

    }

    //This is by InOrder Approach, with the help of static pointer prev(to store values in runtime recursively)

    //Time Complexity: O(n)
    static Node prev = null;
    public void convert_to_DLL_better(Node key){
        if(key == null)
            return;

        convert_to_DLL_better(key.left);

        if(head == null){
            head = key;
        }
        else {
            key.left = prev;
            prev.right = key;
        }
        prev = key;


        convert_to_DLL_better(key.right);
    }

    public void printList(Node key){
        if(key == null)
            return;

        while (key!=null){
            System.out.print(key.data + " ");
            key = key.right;
        }
    }

    public static void main(String[] args) {
        BT_Doubly_LL BT = new BT_Doubly_LL();
        BT.root = new Node(10);
        BT.root.left = new Node(12);
        BT.root.right = new Node(15);
        BT.root.left.left = new Node(25);
        BT.root.left.right = new Node(30);
        BT.root.right.left = new Node(36);
        BT.root.right.right = new Node(40);

        //Node temp = BT.convert_to_DLL(BT.root);

        BT.convert_to_DLL_better(BT.root);

//        while (temp.left!=null){
//            temp = temp.left;
//        }

        BT.printList(BT.head);


    }


}
