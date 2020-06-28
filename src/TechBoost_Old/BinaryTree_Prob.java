package TechBoost_Old;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 21/03/18.
 */
public class BinaryTree_Prob {
    BTNode root;

    static class BTNode{
        BTNode left, right;
        int data;

        BTNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void levelOrder_iterative(BTNode key){
        if(key == null)
            return;

        Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.add(key);

        while (!queue.isEmpty()){
            BTNode temp = queue.remove();
            System.out.print(temp.data + " ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

    }

    public void preOrder_recursive(BTNode Nd){
        if(Nd == null){
            return;
        }
        System.out.print(Nd.data + " ");
        preOrder_recursive(Nd.left);
        preOrder_recursive(Nd.right);
    }

    public void preOrder_iterative(BTNode key){
        if(key == null)
            return;

        Stack<BTNode> stack = new Stack<>();
        stack.push(key);

        while (!stack.isEmpty()){
            BTNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }

    }

    public void postOrder_recursive(BTNode Nd){
        if(Nd == null){
            return;
        }
        postOrder_recursive(Nd.left);
        postOrder_recursive(Nd.right);
        System.out.print(Nd.data + " ");
    }

    public void postOrder_iterative(BTNode key){
        Stack<BTNode> stack = new Stack<>();

        BTNode curr = key;
        BTNode prev = null;

        stack.push(curr);

        while (!stack.isEmpty()){
            curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left!=null){
                    stack.push(curr.left);
                }
                else if(curr.right!=null){
                    stack.push(curr.right);
                }
                else {
                    System.out.print(stack.pop().data + " ");
                }
            }
            else if(curr.left == prev){
                if(curr.right!=null){
                    stack.push(curr.right);
                }
                else {
                    System.out.print(stack.pop().data + " ");
                }
            }
            else if(curr.right == prev){
                System.out.print(stack.pop().data + " ");
            }
            prev = curr;
        }
    }


    public void inOrder_recursive(BTNode Nd){
        if(Nd == null){
            return;
        }
        inOrder_recursive(Nd.left);
        System.out.print(Nd.data + " ");
        inOrder_recursive(Nd.right);
    }



    public void inOrder_iterative(BTNode key){
        if(key == null)
            return;

        boolean flag = false;
        Stack<BTNode> stack = new Stack<>();

        BTNode temp = key;

        while (!flag){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            else {
                if(stack.isEmpty()){
                    flag = true;
                }
                else {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    temp = temp.right;
                }
            }
        }

    }



    public int height_recur(BTNode key){
        if(key == null)
            return 0;

        int hleft = height_recur(key.left);
        int hright = height_recur(key.right);

        return Math.max(hleft, hright) + 1;
    }

    public int maxElement(BTNode key){
        if(key == null)
            return Integer.MIN_VALUE;

        int lmax = maxElement(key.left);
        int rmax = maxElement(key.right);

        return Math.max(key.data, Math.max(lmax, rmax));
    }

    public int num_of_elements(BTNode key){
        if(key == null)
            return 0;

        int lCount = num_of_elements(key.left);
        int rCount = num_of_elements(key.right);

        return lCount + rCount +1;
    }

    public int num_of_leaf_nodes(BTNode key){
        if(key == null)
            return 0;

        if(key.left == null && key.right == null)
            return 1;

        int lCount = num_of_leaf_nodes(key.left);
        int rCount = num_of_leaf_nodes(key.right);

        return lCount + rCount;
    }

    public BTNode search(BTNode key, int x){
        if(key== null) return null;

        if(key.data == x) return key;

        BTNode nLeft = search(key.left, x);
        if(nLeft!=null)
            return nLeft;

        BTNode nRight = search(key.right, x);
        if(nRight!=null)
            return nRight;

        return null;



    }

    public BTNode LCA(BTNode key, BTNode a, BTNode b){
        if(key == null) return null;

        //if(search(key, a.data) == null || search(key, b.data) == null)
          //  return null;

        if(key == a) return key;

        if(key == b) return key;

        BTNode lKey = LCA(key.left, a, b);
        BTNode rKey = LCA(key.right, a, b);

        if(lKey!=null && rKey!=null)
            return key;

        if(lKey!=null)
            return lKey;
        else
            return rKey;

    }

    public static void main(String[] args) {
        BinaryTree_Prob BT = new BinaryTree_Prob();
        BT.root = new BTNode(2);
        BT.root.left = new BTNode(3);
        BT.root.right = new BTNode(4);
        BT.root.left.left = new BTNode(5);
        BT.root.left.right = new BTNode(6);

        System.out.print("LevelOrder Traversal using Iterative Approach: ");
        BT.levelOrder_iterative(BT.root);
        System.out.println();


        System.out.print("PreOrder Traversal using Recursive Approach: ");
        BT.preOrder_recursive(BT.root);
        System.out.println();

        System.out.print("PreOrder Traversal using Iterative Approach: ");
        BT.preOrder_iterative(BT.root);
        System.out.println();

        System.out.print("PostOrder Traversal using Recursive Approach: ");
        BT.postOrder_recursive(BT.root);
        System.out.println();

        System.out.print("PostOrder Traversal using Iterative Approach: ");
        BT.postOrder_iterative(BT.root);
        System.out.println();

        System.out.print("InOrder Traversal using Recursive Approach: ");
        BT.inOrder_recursive(BT.root);
        System.out.println();

        System.out.print("InOrder Traversal using Iterative Approach: ");
        BT.inOrder_iterative(BT.root);
        System.out.println();

        System.out.println("Height of Binary Tree is: " + BT.height_recur(BT.root));

        System.out.println("Maximum Value in Binary Tree is: " + BT.maxElement(BT.root));

        System.out.println("Number of Nodes in Binary Tree is: " + BT.num_of_elements(BT.root));

        System.out.println("Number of Leaf Nodes in Binary Tree is: " + BT.num_of_leaf_nodes(BT.root));

        System.out.print("Searching Node in Binary Tree is: ");
        if(BT.search(BT.root, 3) == null) System.out.print("null");
        else System.out.print(BT.search(BT.root, 3).data);

        System.out.println("LCA of " + BT.root.left.left.data + "&" + BT.root.left.right.data + " is "  +
                BT.LCA(BT.root, BT.root.left.left, BT.root.left.right).data);

    }
}
