package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 31/07/17.
 */
public class RightNeighbour {
    Node root;

    static class Node{
        Node left, right, neighbor;
        int data;
        int level;

        Node(int data){
            this.data = data;
            this.left = this.right = this.neighbor = null;
            this.level = 0;
        }

    }

    RightNeighbour(int data){
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

//    public int getLevel(Node key){
//        if(key == null)
//            return -1;
//
//        if(root == key)
//            return 0;
//        Node temp = root;
//        while (temp!=null){
//
//        }
//    }

    public void rightNeighbour_populate(Node key){
        if(key == null)
            return;

        int n = getHeight(key);

        for(int i = 0; i < n ; i++){
            rightNeighbour_populate_util(key, i);
        }


    }


    public void rightNeighbour_populate_util_BFS(Node key, int level){
        if(key == null)
            return;

        if(level == 0){
            System.out.print(key.data + " ");
            return;
        }

        else {
            rightNeighbour_populate_util(key.left, level-1);
            rightNeighbour_populate_util(key.right, level-1);
        }
    }

    public void rightNeighbour_BFS_iterative(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(key);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.data + " ");
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);

        }
    }

    public void print_Right_Neigbour(Node key){
        if(key == null)
            return;

        if(key.neighbor == null) {
            System.out.println(key.data + " -> NULL");
            return;
        }

        else {
            System.out.println(key.data + " -> " + key.neighbor.data);
            return;
        }
    }

    public void rightNeighbour_BFS_iterative_RN(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(key);

        while (!queue.isEmpty()){
            Node peek1 = queue.peek();
            Node temp = queue.remove();
            Node peek2 = queue.peek();
            //System.out.print(temp.data + " ");

            if(peek1!=null && peek2!=null && peek1.level == peek2.level){
                peek1.neighbor = peek2;
            }

            if(getLeft(temp)!=null)
                queue.add(temp.left);
            if(getRight(temp)!=null)
                queue.add(temp.right);

        }
    }

    public void rightNeighbour_populate_util(Node key, int level){
        if(key == null)
            return;

        if(level == 0){
            System.out.print(key.data + " ");
            return;
        }

        else {
            if(key.left!=null && key.right!=null){
                key.left.neighbor = key.right;
            }
            rightNeighbour_populate_util(key.left, level-1);
            rightNeighbour_populate_util(key.right, level-1);
        }
    }



    public Node getLeft(Node key){
        if(key == null || key.left == null)
            return null;
        key.left.level += key.level;
        return key.left;
    }

    public Node getRight(Node key){
        if(key == null || key.right == null)
            return null;
        key.right.level += key.level;
        return key.right;
    }

    public static void main(String[] args) {
        RightNeighbour BT = new RightNeighbour(0);
        BT.root.left = new Node(1);
        BT.root.right = new Node(2);
        BT.root.left.left = new Node(3);
        BT.root.right.left = new Node(5);
        BT.root.right.right = new Node(6);
        BT.root.right.right.left = new Node(7);
        BT.root.right.right.right = new Node(8);

        //BT.rightNeighbour_populate(BT.root);

        //BT.rightNeighbour_BFS_iterative(BT.root);

        BT.rightNeighbour_BFS_iterative_RN(BT.root);

        BT.print_Right_Neigbour(BT.root.right.right.right);


    }
}
