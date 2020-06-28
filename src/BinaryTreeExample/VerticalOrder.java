package BinaryTreeExample;

import java.util.TreeMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 31/07/17.
 */
public class VerticalOrder {
    Node root;

    static class Node{
        Node left, right;
        int data;
        int level;

        Node(int data){
            this.data = data;
            left = right = null;
            this.level = 0;
        }
    }

    VerticalOrder(int data){
        if(root == null)
            root = new Node(data);
    }

    public Node getLeft(Node key){
        if(key == null || key.left == null)
            return null;
        key.left.level = key.level -1;
        return key.left;
    }

    public Node getRight(Node key){
        if(key == null || key.right == null)
            return null;
        key.right.level = key.level +1;
        return key.right;
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

    static TreeMap<Integer, String> tree = new TreeMap<>();
    public void vertical_Order_Recur(Node key){
        if(key == null)
            return;

        vertical_Order_Recur(getLeft(key));
        vertical_Order_Recur(getRight(key));

        if(tree.containsKey(key.level)){
            if(!tree.get(key.level).contains(" ") && getHeight(key) ==  getHeight(new Node(Integer.valueOf(tree.get(key.level)))))
                tree.put(key.level, tree.get(key.level) + " " + key.data + " " );
            else
                tree.put(key.level, key.data + " " + tree.get(key.level) + " ");
        }
        else
            tree.put(key.level, String.valueOf(key.data));

    }

    public static void main(String[] args) {
//        VerticalOrder BT = new VerticalOrder(50);
//        System.out.println("Root: " + BT.root.data);
//        BT.root.left = new Node(30);
//        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
//        BT.root.right = new Node(70);
//        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
//        BT.root.left.left = new Node(20);
//        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
//        BT.root.left.right = new Node(40);
//        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
//        BT.root.right.left = new Node(60);
//        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
////        BT.root.right.right = new Node(80);

        VerticalOrder BT = new VerticalOrder(3);
        BT.root.left = new Node(4);
        BT.root.left.left = new Node(6);
        BT.root.left.left.right = new Node(10);
        BT.root.left.left.right.right = new Node(11);
        BT.root.left.right = new Node(7);
        BT.root.left.right.right = new Node(1);
        BT.root.right = new Node(5);
        BT.root.right.left = new Node(8);
        BT.root.right.right = new Node(9);



        BT.vertical_Order_Recur(BT.root);


        for(Map.Entry entry: tree.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
