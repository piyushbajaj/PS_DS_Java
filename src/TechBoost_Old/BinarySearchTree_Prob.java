package TechBoost_Old;

/**
 * Created by piyush.bajaj on 22/03/18.
 */
public class BinarySearchTree_Prob {
    BSTNode root;

    static class BSTNode {
        BSTNode left, right;
        int data;

        BSTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public int maxElement(BSTNode key) {
        if (key == null)
            return Integer.MIN_VALUE;

        int lmax = maxElement(key.left);
        int rmax = maxElement(key.right);

        return Math.max(key.data, Math.max(lmax, rmax));
    }

    public int minElement(BSTNode key) {
        if (key == null)
            return Integer.MAX_VALUE;

        int lmin = minElement(key.left);
        int rmin = minElement(key.right);

        return Math.min(key.data, Math.min(lmin, rmin));
    }

    /*
    Time Complexity: O(N*N)
    Space Complexity: O(logN)
     */
    public boolean isBST(BSTNode key) {
        if (key == null)
            return true;

        if (key.left != null && maxElement(key.left) > key.data)
            return false;
        if (key.right != null && minElement(key.right) < key.data)
            return false;


        boolean lNode = isBST(key.left);
        boolean rNode = isBST(key.right);

        return lNode && rNode;


    }

    /*
    Time Complexity: O(N)
    Space: O(logN)
     */

    public boolean isBST_better(BSTNode key) {
        if (key == null)
            return true;

        return isBST_Util(key, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public boolean isBST_Util(BSTNode key, int Min, int Max){
        if(key == null) return true;

        if(key.data < Min) return false;

        if(key.data > Max) return false;

        return isBST_Util(key.left, Min, key.data) &&
                isBST_Util(key.right, key.data, Max);
    }


    public BSTNode LCA(BSTNode key, BSTNode a, BSTNode b){
        if(key == null)
            return null;

        if(a.data < key.data && b.data < key.data)
            return LCA(key.left, a, b);
        else if(a.data > key.data && b.data > key.data)
            return LCA(key.right, a, b);

        return key;
    }

    public BSTNode insertBST(BSTNode key, int data){
        //BSTNode Nd = new BSTNode(data);

        if(key == null) {
            key = new BSTNode(data);

            if(root == null)
                root = key;

            return key;
        }

        if(data > key.data){
            key.right = insertBST(key.right, data);
        }
        else
            key.left = insertBST(key.left, data);

        return key;


    }

    public void printTree_inOrder(BSTNode key){
        if(key == null)
            return;

        printTree_inOrder(key.left);
        System.out.print(key.data + " ");
        printTree_inOrder(key.right);
    }

    public static void main(String[] args) {
        BinarySearchTree_Prob BT = new BinarySearchTree_Prob();
//        BT.root = new BSTNode(2);
//        BT.root.left = new BSTNode(3);
//        BT.root.right = new BSTNode(4);
//        BT.root.left.left = new BSTNode(5);
//        BT.root.left.right = new BSTNode(6);

//        BT.root = new BSTNode(40);
//        BT.root.left = new BSTNode(20);
//        BT.root.right = new BSTNode(60);
//        BT.root.left.left = new BSTNode(10);
//        BT.root.left.right = new BSTNode(30);
//        BT.root.right.left = new BSTNode(50);
//        BT.root.right.right = new BSTNode(70);

        BT.insertBST(BT.root, 40);
        BT.insertBST(BT.root, 20);
        BT.insertBST(BT.root, 60);
        BT.insertBST(BT.root, 10);
        BT.insertBST(BT.root, 30);
        BT.insertBST(BT.root, 50);
        BT.insertBST(BT.root, 70);



        System.out.println(BT.isBST(BT.root));

        System.out.println(BT.isBST_better(BT.root));

        System.out.println("LCA of " + BT.root.left.left.data + " & " + BT.root.left.right.data + " is: " +
                BT.LCA(BT.root, BT.root.left.left, BT.root.left.right).data);

        System.out.print("BST in InOrder: ");
        BT.printTree_inOrder(BT.root);
    }
}