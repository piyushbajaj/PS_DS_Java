package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 24/12/16.
 */
public class BFS_LCA {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public BFS_LCA(){
        root = null;
    }

    public BFS_LCA(int key){
        root = new Node(key);
    }

    Node findLCA(Node node, int n1, int n2)
    {
        if(node == null)
            return null;



        if(node.data ==n1 || node.data == n2)
            return node;

        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        if(left_lca!=null && right_lca!=null)
            return node;

        return (left_lca!=null)? left_lca: right_lca;

//
//
//        // Base case
//        if (node == null)
//            return null;
//
//        // If either n1 or n2 matches with root's key, report
//        // the presence by returning root (Note that if a key is
//        // ancestor of other, then the ancestor key becomes LCA
//        if (node.data == n1 || node.data == n2)
//            return node;
//
//        // Look for keys in left and right subtrees
//        Node left_lca = findLCA(node.left, n1, n2);
//        Node right_lca = findLCA(node.right, n1, n2);
//
//        // If both of the above calls return Non-NULL, then one key
//        // is present in once subtree and other is present in other,
//        // So this node is the LCA
//        if (left_lca!=null && right_lca!=null)
//            return node;
//
//        // Otherwise check if left subtree or right subtree is LCA
//        return (left_lca != null) ? left_lca : right_lca;
    }


    public Node lca_prac(Node key, int a, int b){
        if(key == null)
            return null;

        if(key.data == a || key.data == b)
            return key;

        Node Llca = lca_prac(key.left, a, b);
        Node Rlca = lca_prac(key.right, a, b);

        if(Llca != null && Rlca != null)
            return key;

        if(Llca!=null)
            return Llca;

        else
            return Rlca;

        //return key;
    }

    public static void main(String[] args) {
        BFS_LCA BT = new BFS_LCA(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        BT.root.left.left.right = new Node(8);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("LCA is: " + BT.findLCA(BT.root, 4, 7).data);

        System.out.println("LCA is: " + BT.lca_prac(BT.root, 4, 7).data);

    }
}
