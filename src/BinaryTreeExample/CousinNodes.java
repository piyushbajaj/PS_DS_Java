package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 26/07/17.
 */
public class CousinNodes {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    CousinNodes(int data){
        if(root == null)
            root = new Node(data);
    }

    int leftlevel=0, rightlevel =0;
    Node leftParent = null;
    Node rightParent = null;
    public Node sibbling(Node key, Node source, Node dest, int level){
        if(key == null)
            return key;

        if(key.left != source && key.right != source && (key.left!=null && key.right != null)) {
            sibbling(key.left, source, dest, level + 1);
        }
        else if(key.left == source || key.right == source){
            leftlevel = level+1;
            leftParent = key;
        }
        if((key.left != dest && key.right != dest) && (key.left!=null && key.right != null)) {
            sibbling(key.right, source, dest, level + 1);
        }
        else if(key.left == dest || key.right == dest){
            rightlevel = level+1;
            rightParent = key;
        }


        if(leftlevel == rightlevel && leftParent!=null){
            if(leftParent == rightParent){
                System.out.println(source.data + " and " + dest.data +  " are not siblings" );
                System.exit(1);
                return key;
            }
            else {
                System.out.println(source.data + " and " + dest.data +  " are siblings" );
                System.exit(1);
                return key;
            }
        }
        else if(leftParent!=null && rightParent!=null)  {
            System.out.println(source.data + " and " + dest.data +  " are not siblings" );
            System.exit(1);
            return key;
        }
        return key;

    }

    public int height(Node key){
        if(key == null)
            return 0;
        int leftcount = height(key.left);
        int rightcount = height(key.right);

        if(leftcount > rightcount)
            return leftcount+1;
        else
            return rightcount+1;
    }


    public boolean isSibling(Node a, Node b) {
        return isSibling(root, a, b);
    }

    private boolean isSibling(Node root, Node a, Node b) {
        if (root == null)
            return false;
        return ((root.left == a && root.right == b) || (root.right == a && root.left == b) ||
                isSibling(root.left, a, b) || isSibling(root.right, a, b));
    }

    public Boolean isCousin(Node a, Node b) {
        // A node cannot be cousin of itself.
        if (a == b) {
            return false;
        }
        return (!isSibling(a, b) && height(a) == height(b));
    }


    public static void main(String[] args) {
        CousinNodes BT = new CousinNodes(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root (" + BT.root.data + ") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        //BT.sibbling(BT.root, BT.root.left, BT.root.right.right, 0);

        System.out.println(BT.isCousin(BT.root.left.left, BT.root.left.right));

    }
}
