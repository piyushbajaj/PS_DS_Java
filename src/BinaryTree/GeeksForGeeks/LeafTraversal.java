package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 03/09/17.
 */
public class LeafTraversal {
    Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    LeafTraversal(){
        root = null;
    }

    LeafTraversal(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    String str = "";
    public String leafTraversal_same(Node key){
        if(key == null)
            return "";

        leafTraversal_same(key.left);
        leafTraversal_same(key.right);

        if(key.left==null && key.right == null)
            str += String.valueOf(key.data);

        return str;
    }

    public static void main(String[] args) {
        LeafTraversal dfs = new LeafTraversal(1);
        dfs.root.left = new Node(2);
        dfs.root.right = new Node(3);
        dfs.root.left.left = new Node(4);
        dfs.root.left.right = new Node(5);
        dfs.root.right.left = new Node(6);
        dfs.root.right.right = new Node(7);

        LeafTraversal dfs1 = new LeafTraversal(10);
        dfs1.root.left = new Node(21);
        dfs1.root.right = new Node(32);
        dfs1.root.left.left = new Node(4);
        dfs1.root.left.right = new Node(5);
        dfs1.root.right.left = new Node(6);
        dfs1.root.right.right = new Node(78);

        if(dfs.leafTraversal_same(dfs.root).equals(dfs1.leafTraversal_same(dfs1.root)))
            System.out.println("Same");
        else
            System.out.println("Different");
    }
}
