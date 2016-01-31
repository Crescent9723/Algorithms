package dataStructure.bst;

import dataStructure.application.DataStructure;

public class BinarySearchTree<T extends Comparable<T>> implements DataStructure {
	Node root;
	
	class Node {
		T data;
		Node left;
		Node right;
		public Node(T data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public int numChildren(){
			if (left != null && right != null){
				return 2;
			} else if (left != null || right != null){
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean search(T data){
		Node current = root;
		while (current != null){
			if (data.compareTo(current.data) == 0){
				System.out.println("Found: " + data);
				return true;
			} else if (data.compareTo(current.data) > 0){
				current = current.right;
			} else {
				current = current.left;
			} 
		}
		System.out.println("Not Found: " + data);
		return false;
	}
	
	public void insert(T data){
		Node newNode = new Node(data, null, null);
		if (root == null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true){
			parent = current;
			if (data.compareTo(current.data) >= 0){
				current = current.right;
				if (current == null){
					parent.right = newNode;
					System.out.println("Inserted: " + data);
					return;
				}
			} else {
				current = current.left;
				if (current == null){
					parent.left = newNode;
					System.out.println("Inserted: " + data);
					return;
				}
			} 
		}
	}
	
	public boolean delete(T data){
		if (root == null){
			return false;
		}
		Node current = root;
		Node deleteNode = null;
		Node parent = null;
		while (current != null){
			if (data.compareTo(current.data) == 0){
				deleteNode = current;
				break;
			} else if (data.compareTo(current.data) > 0){
				parent = current;
				current = current.right;
			} else {
				parent = current;
				current = current.left;
			}
		}
		if (deleteNode != null){
			if (deleteNode.numChildren() == 2){
				Node child = findPredecessor(deleteNode);
				if (deleteNode == parent.left){
					parent.left = child;
				} else {
					parent.right = child;
				}
			} else if (deleteNode.numChildren() == 1){
				if (deleteNode.left != null){
					Node child = deleteNode.left;
					if (deleteNode == parent.left){
						parent.left = child;
					} else {
						parent.right = child;
					}
				} else {
					Node child = deleteNode.right;
					if (deleteNode == parent.left){
						parent.left = child;
					} else {
						parent.right = child;
					}
				}
			} else {
				if (deleteNode == parent.left){
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			System.out.println("Deleted: " + data);
			return true;
		}
		System.out.println("Not Found: " + data);
		return false;
	}
	
	public Node findPredecessor(Node node){
		Node child = node.left;
		while (child.right != null){
			child = child.right;
		}
		return child;
	}
	@Override
	public void printCurrentData() {
		inOrderPrint(root);
		System.out.println();
	}
	
	public void inOrderPrint(Node node){
		if (node == null){
			return;
		}
		inOrderPrint(node.left);
		System.out.print(node.data + " ");
		inOrderPrint(node.right);
	}
}
