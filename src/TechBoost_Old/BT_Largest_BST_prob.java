package TechBoost_Old;

/**
 * Created by piyush.bajaj on 05/05/18.
 */
public class BT_Largest_BST_prob {
    BSTNode root;

    static class BSTNode{
        BSTNode left, right;
        int data;

        BSTNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class MinMax{
        boolean flag;
        int size;
        int min;
        int max;

        MinMax(){
            flag = false;
            size = 1;
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
        }
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

    public MinMax largestBST(BSTNode key){
        if(key == null)
            return new MinMax();


        return null;
    }


    public static void main(String[] args) {
        BT_Largest_BST_prob BT = new BT_Largest_BST_prob();
        BT.insertBST(BT.root, 40);
        BT.insertBST(BT.root, 20);
        BT.insertBST(BT.root, 60);
        BT.insertBST(BT.root, 10);
        BT.insertBST(BT.root, 30);
        BT.insertBST(BT.root, 50);
        BT.insertBST(BT.root, 70);


    }
}
