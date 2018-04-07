import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	TreeNode root;
	
	public BinaryTree(int key) {
		this.root = new TreeNode(key);
	}
	
	public BinaryTree() {
		root = null;
	}
	
	public void printPreorder(TreeNode node) {
		if (node == null) return;
		System.out.print(node.key + "->");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public void printPostorder(TreeNode node) {
		if (node == null) return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key + "->");
	}
	
	public void printInorder(TreeNode node) {
		if (node == null) return;
		printInorder(node.left);
		System.out.print(node.key + "->");
		printInorder(node.right);
	}
	
	public void levelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (node != null) queue.add(node);
		
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.print(currentNode.key + "->");
			
			if (currentNode.left != null) queue.add(currentNode.left);
			if (currentNode.right != null) queue.add(currentNode.right);	
		}
	}
	
	public static void main(String args[]) {
		BinaryTree BT = new BinaryTree();
		BT.root = new TreeNode(1);
		BT.root.left = new TreeNode(2);
		BT.root.left.left = new TreeNode(4);
		BT.root.left.right = new TreeNode(5);
		BT.root.right = new TreeNode(3);
		BT.root.right.left = new TreeNode(6);
		BT.root.right.right = new TreeNode(7);
		BT.printInorder(BT.root);
		BT.printPreorder(BT.root);
		BT.printPostorder(BT.root);
		BT.levelOrder(BT.root);
	}
}
