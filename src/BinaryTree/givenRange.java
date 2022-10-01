package BinaryTree;

/**
 * Created by piyush.bajaj on 28/12/16.
 */
public class givenRange {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public givenRange(){
        root = null;
    }

    public givenRange(int key){
        root = new Node(key);
    }

    public void printGivenRange(Node key, int k1, int k2){
        if(key == null)
            return;
        if(key.data > k1)
            printGivenRange(key.left, k1, k2);
        if(key.data >=k1 && key.data <=k2)
            System.out.print(key.data + " ");
        if(key.data < k2)
            printGivenRange(key.right, k1, k2);

        return;
    }

    public static void main(String[] args) {
        givenRange BT = new givenRange(20);
        BT.root.left = new Node(8);
        BT.root.right = new Node(22);
        BT.root.left.left = new Node(4);
        BT.root.left.right = new Node(12);
        BT.printGivenRange(BT.root, 10, 22);
        System.out.println();
    }


}
