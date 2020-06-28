package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 24/07/17.
 */
public class oddDepth {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    oddDepth(int data){
        if(root == null)
            root = new Node(data);
    }

    static int count = 1;
    public void odd_deepest_depth(Node key, int depth){
        if(key == null)
            return;

        if(depth > count && depth%2 == 1){
            count = depth;
        }
        odd_deepest_depth(key.left, depth+1);
        odd_deepest_depth(key.right, depth+1);

    }

    public static void main(String[] args) {
        oddDepth SN = new oddDepth(0);
        SN.root.left = new Node(1);
        SN.root.right = new Node(2);
        SN.root.left.left = new Node(3);
        SN.root.left.right = new Node(4);
        SN.root.left.left.right = new Node(6);
        //SN.root.left.left.right.right = new Node(8);
        SN.root.right.left = new Node(5);
        SN.root.right.left.right = new Node(7);

        SN.odd_deepest_depth(SN.root, 1);
        System.out.println(count);
    }
}
