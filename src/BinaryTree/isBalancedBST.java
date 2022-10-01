package BinaryTree;

/**
 * Created by piyush.bajaj on 05/08/17.
 */
public class isBalancedBST {
    Node root;

    static class Node{
        Node left, right, neighbor;
        int data;
        int count;

        Node(int data){
            this.data = data;
            this.left = this.right = this.neighbor = null;
            this.count = 0;
        }

    }

    isBalancedBST(int data){
        if(root == null)
            root = new Node(data);
    }

    public int getHeight(Node key){
        if(key == null)
            return 0;

        int lCount = getHeight(key.left);
        int rCount = getHeight(key.right);

        if(lCount > rCount)
            return lCount+1;
        else
            return rCount+1;
    }

    int count = 0;
    public int checkBalance(Node key){
        if(key == null)
            return 0;

        int lCount = checkBalance(key.left);
        int rCount = checkBalance(key.right);

//        if(key.left == null && key.right == null)
//            key.count += 0;
//
//        else if(key.left == null || key.right!=null)
//            key.count +=1;
//
//        else if(key.left != null || key.right==null)
//            key.count +=1;
//
//        else if(key.left!=null && key.right != null)
//            key.count +=1;

        if(key.left!=null || key.right!=null){
            count++;
        }

        if(Math.abs(lCount - rCount) > 1){
            System.out.println("False");
            return -1;
        }
        else
        return count;



    }

    public static void main(String[] args) {
        isBalancedBST BT = new isBalancedBST(40);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(20);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(60);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(10);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(30);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(50);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(70);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.root.right.right.right = new Node(80);

        if(BT.checkBalance(BT.root) != -1)
            System.out.println("TRUE");

    }
}
