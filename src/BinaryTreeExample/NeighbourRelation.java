package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 22/03/17.
 */
public class NeighbourRelation {
    Node root;

    static class Node{
        Node left, right, neighbour;
        int data;

        Node(int data){
            this.data = data;
            this.left = this.right = this.neighbour = null;
        }
    }

    public void push(int val){
        Node new_node = new Node(val);
        if(root==null) {
            root = new_node;
            return;
        }

        Node temp = root;

        while (temp !=null){
            if(val< temp.data) {
                if(temp.left==null) {
                    temp.left = new_node;
                    return;
                }
                else {
                    temp = temp.left;
                }
            }
            else if(val > temp.data) {
                if(temp.right==null) {
                    temp.right = new_node;
                    return;
                }
                else {
                    temp = temp.right;
                }
            }
        }
    }

    //InorderTraversal
    public void printList(Node key){
        if(key==null)
            return;

        printList(key.left);
        System.out.print(key.data + " ");
        printList(key.right);
    }

    public void printBFS(Node key){
        if(key == null)
            return;

        int h = height(key);

        for(int i = 1; i <= h; i++){
            printLevelBFS_neigbourNode(key, i);
        }
    }

    public void printLevelBFS(Node key, int level){
        if(key == null)
            return;

        if(level == 1)
            System.out.print(key.data + " ");

        if(level > 1){
            printLevelBFS(key.left, level-1);
            printLevelBFS(key.right, level-1);
        }
    }

    public Node printLevelBFS_neigbourNode(Node key, int level){
        if(key == null)
            return null;

        Node neighNode = null;


        if(level == 1)
            return key;



        if(level > 1){
            neighNode = printLevelBFS_neigbourNode(key.left, level - 1);
            if(neighNode.neighbour==null)
                neighNode.neighbour = printLevelBFS_neigbourNode(key.right, level-1);
        }

        return neighNode;

    }



    public int height(Node key){
        if(key==null)
            return 0;

        int lheight = height(key.left);
        int rheight = height(key.right);

        if(lheight > rheight)
            return lheight+1;
        else
            return rheight+1;
    }


    public void populateNeighbourNode(Node key){
        if(key == null)
            return;

        if(key.left!=null){
            if(key.right!=null){
                key.left.neighbour = key.right;
            }
            else {
                Node parentNeighbour = key.neighbour;
                Node neighbourhood;

                while (parentNeighbour!=null) {
                    neighbourhood = (parentNeighbour.left != null) ? parentNeighbour.left : parentNeighbour.right;

                    if(neighbourhood!=null){
                        key.left.neighbour = neighbourhood;
                        break;
                    }

                    parentNeighbour = parentNeighbour.neighbour;
                }
            }
        }

        if(key.right!=null){
            Node parentNeighbour = key.neighbour;
            Node neighbourhood;

            while (parentNeighbour!=null) {
                neighbourhood = (parentNeighbour.left != null) ? parentNeighbour.left : parentNeighbour.right;

                if(neighbourhood!=null){
                    key.right.neighbour = neighbourhood;
                    break;
                }

                parentNeighbour = parentNeighbour.neighbour;
            }
        }

        populateNeighbourNode(key.right);

        populateNeighbourNode(key.left);
    }


    public static void main(String[] args) {
        NeighbourRelation PO = new NeighbourRelation();
        PO.push(4);
        PO.push(2);
        PO.push(1);
        PO.push(3);
        PO.push(6);
        PO.push(5);
        PO.push(7);
        PO.push(8);

        PO.printList(PO.root);
        System.out.println();

        //PO.printBFS(PO.root);

        PO.populateNeighbourNode(PO.root);

        System.out.println(PO.root.data + "-> Neighbour: (" + PO.root.neighbour + ")");

        System.out.println(PO.root.left.data + "-> Neighbour: (" + PO.root.left.neighbour.data + ") -> " + PO.root.right.data);

        System.out.println(PO.root.left.left.data + "-> Neighbour: (" + PO.root.left.left.neighbour.data + ") -> "
                + PO.root.left.right.data + "-> Neighbour: ("
                + PO.root.left.right.neighbour.data + ") -> " + PO.root.right.left.data + "-> Neighbour: ("
                + PO.root.right.left.neighbour.data + ") -> " + PO.root.right.right.data + "-> Neighbour: ("
                        + PO.root.right.right.neighbour + ")"
                );
    }


}
