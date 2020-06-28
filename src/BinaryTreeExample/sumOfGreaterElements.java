package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 31/12/16.
 */
public class sumOfGreaterElements {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public sumOfGreaterElements(){
        root = null;
    }

    public sumOfGreaterElements(int key){
        root = new Node(key);
    }

    class IntWrapper{
        int val=0;
    }


//    public void modifyUtil(Node key, IntWrapper sum){
//        if(key == null)
//            return;
//
//            modifyUtil(key.right, sum);
//
//            sum.val += key.data;
//            key.data = sum.val;
//
//            modifyUtil(key.left, sum);
//
//    }
//
//    //static IntWrapper int_ptr = new IntWrapper();
//    //public static int sum =0;
//    public void modify(Node key){
//
//        modifyUtil(key, sum);
//    }

    //This can be done using InOrder Reversal Technique
    public int addSum(Node node,int sum){
        if(node.right!=null)
            sum=addSum(node.right,sum);
        if(node!=null){
            node.data+=sum;
            sum=node.data;
        }
        if(node.left!=null)
            sum=addSum(node.left,sum);
        return sum;
    }

    public static void main(String[] args) {

        sumOfGreaterElements BT = new sumOfGreaterElements(50);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(30);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(70);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(20);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(40);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(60);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(80);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.addSum(BT.root,0);

        System.out.println("Root: " + BT.root.data);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);


        //System.out.println("In-Order Traversal Using Recursive: " + IO.inOrderTraversal(BT.root));

    }


}
