package BinaryTree;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 28/07/17.
 */
public class TopView {
    Node root;

    static class Node {
        Node left, right;
        int data;
        int distance = 0;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.distance = 0;
        }

    }

    TopView(int data) {
        if (root == null)
            root = new Node(data);
    }

    public Node getLeft(Node key) {
        if (key.left == null)
            return null;

        key.left.distance = key.distance - 1;
        return key.left;
    }

    public Node getRight(Node key) {
        if (key.right == null)
            return null;

        key.right.distance = key.distance + 1;
        return key.right;
    }


    static int minSoFar = Integer.MAX_VALUE;
    static int maxSoFar = Integer.MIN_VALUE;
    static HashMap<Integer, Node> hash = new HashMap<>();

    public Node topViewTree(Node key) {
        if (key == null)
            return null;


        if (hash.isEmpty()) {
            hash.put(key.distance, key);
        }

        Node lNode = topViewTree(getLeft(key));
        Node rNode = topViewTree(getRight(key));

        if (lNode != null && !hash.containsKey(lNode.distance)) {
            if (minSoFar > lNode.distance)
                minSoFar = lNode.distance;
            hash.put(lNode.distance, lNode);

        }
        if (rNode != null && !hash.containsKey(rNode.distance)) {
            if (maxSoFar < rNode.distance)
                maxSoFar = rNode.distance;
            hash.put(rNode.distance, rNode);
        }

        if (hash.containsKey(key.distance)) {
            if (getHeight(key) > getHeight(hash.get(key.distance)))
                hash.put(key.distance, key);
        }
        return key;


    }

    public int getHeight(Node key) {
        if (key == null)
            return 0;

        int lCount = getHeight(key.left);
        int rCount = getHeight(key.right);

        if (lCount > rCount)
            return lCount + 1;
        else
            return rCount + 1;
    }

//    public int getHeightValue(Integer Val){
////        if(key == null)
////            return 0;
//
//        int lCount = getHeight(key.left);
//        int rCount = getHeight(key.right);
//
//        if(lCount > rCount)
//            return lCount+1;
//        else
//            return rCount+1;
//    }


    public static void main(String[] args) {
        TopView BT = new TopView(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.root.left.left.right = new Node(8);
        BT.root.left.right.left = new Node(9);
        BT.root.right.left.right = new Node(10);
        BT.root.right.right.right = new Node(11);

        //System.out.println(BT.getHeight(BT.root));
        BT.topViewTree(BT.root);

        //Iterator<Map.<Node, Integer>> itr = hash.entrySet().iterator();


        //System.out.println(hash.values().);
        //Collections.sor

        System.out.println(minSoFar);
        System.out.println(maxSoFar);
        for (int i = minSoFar; i <= maxSoFar; i++) {
            if (hash.containsKey(i))
                System.out.print(hash.get(i).data + " ");
        }
//        for(Map.Entry<Integer, Node> e : hash.entrySet()){
//            System.out.println(e.getValue().data);
//        }
    }


}
