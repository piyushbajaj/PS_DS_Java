package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 16/09/17.
 */
public class sumProperty {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public sumProperty(){
        root = null;
    }

    public sumProperty(int key){
        root = new Node(key);
    }


    public boolean sumCheck(Node key){
        if(key == null || (key.left==null && key.right == null)) {
            return true;
        }

        int left= 0, right = 0;
        if(key.left!=null)
            left = key.left.data;
        if(key.right!=null)
            right = key.right.data;

        if(left + right == key.data && sumCheck(key.left) && sumCheck(key.right))
            return true;
        else return false;
    }

    public static void main(String[] args) {
        sumProperty tree = new sumProperty();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(1);

        System.out.println(tree.sumCheck(tree.root));
    }
}
