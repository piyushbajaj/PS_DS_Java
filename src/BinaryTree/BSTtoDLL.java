package BinaryTree;

/**
 * Created by piyush.bajaj on 24/12/16.
 */
public class BSTtoDLL {
    Node root;

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public BSTtoDLL() {
        root = null;
    }

    public BSTtoDLL(int key) {
        root = new Node(key);
    }

    public Node BSTtoDLL_recur_Util(Node key) {
        if (key == null)
            return key;

        //Convert left subtree into Doubly Linked List
        if (key.left != null) {
            Node prev = BSTtoDLL_recur_Util(key.left);

            //Shift the prev pointer to the End
            for (; prev.right != null; prev = prev.right) ;

            prev.right = key;
            key.left = prev;
        }

        if (key.right != null) {
            Node next = BSTtoDLL_recur_Util(key.right);

            //Shift the Next pointer to the Start
            for (; next.left != null; next = next.left) ;

            next.left = key;
            key.right = next;
        }

        return key;
    }

    public Node BSTtoDLL_recur(Node key) {
        if (key == null)
            return key;

        key = BSTtoDLL_recur_Util(key);

        while (key.left != null) {
            key = key.left;
        }

        return key;

    }

    public void printNodes(Node key) {
        while (key != null) {
            System.out.print(key.data + " ");
            key = key.right;
        }
    }

    public static void main(String[] args) {
        BSTtoDLL BT = new BSTtoDLL(4);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(6);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(1);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(5);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("After converting to Doubly Linked List: ");
        //BT.printNodes(BT.BSTtoDLL_recur(BT.root));

        BT.printNodes(BT.BSTtoDLL_recur_prac(BT.root));

    }

    public Node BSTtoDLL_recur_prac(Node Nd) {
        if (Nd == null)
            return null;

        Nd = BSTtoDLL_recur_prac_util(Nd);

        while (Nd.left != null)
            Nd = Nd.left;

        return Nd;
    }

    public Node BSTtoDLL_recur_prac_util(Node key) {
        if (key == null)
            return null;

        Node prev;
        Node next;

        if (key.left != null) {
            prev = BSTtoDLL_recur_prac_util(key.left);

            while (prev.right != null)
                prev = prev.right;

            prev.right = key;
            key.left = prev;
        }

        if (key.right != null) {
            next = BSTtoDLL_recur_prac_util(key.right);

            while (next.left != null)
                next = next.left;

            next.left = key;
            key.right = next;
        }

        return key;
    }

}
