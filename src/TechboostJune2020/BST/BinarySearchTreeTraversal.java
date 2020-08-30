package TechboostJune2020.BST;

public class BinarySearchTreeTraversal {
	TreeNode root;

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public TreeNode pushInBST(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data);

			if(root == null) {
				root = node;
			}

			return node;
		}

		if (node.data < data) {
			node.right = pushInBST(node.right, data);
		}
		else {
			node.left = pushInBST(node.left, data);
		}

		return node;
	}

	public void printTree(TreeNode node) {
		if(node == null)
			return;

		printTree(node.left);
		System.out.print(node.data + " ");
		printTree(node.right);
	}

	public int height(TreeNode root) {
		if (root == null) return 0;

		TreeNode Node = root;
		int h = 0;
		while (Node.left != null) {
			h++;
			Node = Node.left;
		}
		return h;

	}

	public static int kthSmallest(TreeNode root, int k, int height)
	{
		// base case
		if (root == null)
			return -1;

		int index = (int) ((Math.pow(2, height) -1)/2) + 1;

		if (k == index)
			return root.data;

		else if (k < index)
			return kthSmallest(root.left, k, height -1);

		else
			return kthSmallest(root.right, k, height -1);
	}

	public static void main(String[] args) {
		BinarySearchTreeTraversal bs = new BinarySearchTreeTraversal();


		bs.kthSmallest(bs.root, 4, bs.height(bs.root));

		bs.pushInBST(bs.root, 10);
		bs.printTree(bs.root);

		System.out.println();
		bs.pushInBST(bs.root, 20);
		bs.printTree(bs.root);

		System.out.println();
		bs.pushInBST(bs.root, 30);
		bs.printTree(bs.root);

		System.out.println();
		bs.pushInBST(bs.root, 5);
		bs.printTree(bs.root);

		System.out.println();
		bs.pushInBST(bs.root, 2);
		bs.printTree(bs.root);

		System.out.println();
		bs.pushInBST(bs.root, 50);
		bs.printTree(bs.root);


	}

}
