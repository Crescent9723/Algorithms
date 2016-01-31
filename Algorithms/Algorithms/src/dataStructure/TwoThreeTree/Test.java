package dataStructure.TwoThreeTree;

public class Test {

	public static void main(String[] args) {
		Tree newTree = new Tree();
		newTree.insertNode(4);
		newTree.insertNode(2);
		newTree.insertNode(19);
		newTree.insertNode(-5);
		newTree.insertNode(6);
		newTree.insertNode(2);
		newTree.insertNode(9);
		newTree.insertNode(8);
		newTree.insertNode(7);
		newTree.insertNode(3);
		newTree.printOut(newTree.getRoot());
		System.out.println();
		newTree.searchNode(3, newTree.getRoot(), 0, false, false);
		newTree.insertNode(12);
		newTree.printOut(newTree.getRoot());
		System.out.println();
		newTree.insertNode(6);
		newTree.printOut(newTree.getRoot());
		System.out.println();
		newTree.deleteNode(3);
		newTree.deleteNode(4);
		newTree.searchNode(1, newTree.getRoot(), 0, false, false);
		newTree.insertNode(15);
		newTree.printOut(newTree.getRoot());
		System.out.println();

	}

}
