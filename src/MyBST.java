/* Implements a BST with TreeNode nodes */

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class MyBST {
	private TreeNode root;
	
	public MyBST() {
		root = null;
	}

	public boolean contains(Object value) {
		return contains(root, value);
	}

	public boolean add(Object value) {
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	public boolean remove(Object value) {
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	public String toString() {
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	// *************** Private helper methods: *********************
	private boolean contains(TreeNode node, Object value) {
		if (node == null)
			return false;
		else {
			int diff = ((Comparable<Object>) value).compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	private TreeNode add(TreeNode node, Object value) {
		if (node == null) {
			return (new TreeNode(value));
		} else {
			int diff = ((Comparable<Object>) value).compareTo(node.getValue());
			if (diff < 0) {
				node.setLeft(add(node.getLeft(), value));
			} else {
				node.setRight(add(node.getRight(), value));
			}
			return node;
		}
	}

	private TreeNode remove(TreeNode node, Object value) {
		int diff = ((Comparable<Object>) node.getValue()).compareTo(value);
		if (diff == 0) {
			return removeRoot(node);
		} else if (diff > 0) {
			if (node.getLeft() != null) {
				node.setLeft(remove(node.getLeft(), value));
			}
		} else {
			if (node.getRight() != null) {
				node.setRight(remove(node.getRight(), value));
			}
		}
		return removeRoot(node);
	}

	private TreeNode removeRoot(TreeNode root) {
		if (root.getRight() == null) {
			return root.getLeft();
		}
		TreeNode temp = root.getRight();
		if (temp.getLeft() != null) {
			while (temp.getLeft().getLeft() != null) {
				temp = temp.getLeft();
			}
			root.setValue(temp.getLeft().getValue());
			if (temp.getLeft().getRight() == null) {
				temp.setLeft(null);
			} else {
				temp.setLeft(temp.getLeft().getRight());
			}
		}
		return root;
	}

	private String toString(TreeNode node) {
		if (node == null)
			return "";
		else
			return toString(node.getLeft()) + node.getValue() + ", " + toString(node.getRight());
	}
}