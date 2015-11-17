package TwoThreeTree;

public class Tree {
	private Node root;
	public Tree() {
		root = null;
	}
	public Node getRoot() {
		return root;
	}
	public Node searchNode(int value, Node node, int index, boolean insertion, boolean deletion){
		
		if (root == null) { // If tree is empty
			return null;
		}
		if (node.checkIfLeaf()){
			if (insertion){
				System.out.println("After the insertion, " + value + " is the element " + (index + 1) + " of the list");
				return node;
			} else if (deletion) {
				System.out.println(value + " is element " + (index + 1) + " of the list");
				return node;
			} else if (node.getKey() == value){
				System.out.println("Found; " + value + " is element " + (index + 1) + " of the list");
				return node;
			} else {
				System.out.println(value + " Is Not Found!");
				return null;
			}
		} else {
			if (value <= node.getMinValue()){
				return searchNode(value, node.getLeftChild(), index, insertion, deletion);
			} else {
				if (node.getRightChild() == null || value <= node.getMaxValue()){
					index += node.getNumLeft();
					return searchNode(value, node.getMidChild(), index, insertion, deletion);
				} else {
					index += node.getNumLeft(); 
					index += node.getNumMid();
					return searchNode(value, node.getRightChild(), index, insertion, deletion);
				}
			}
		}
	}
	public void insertNode(int value){
		if (root == null){ // If tree is empty
			root = new Node(value, null);
		} else if (root.getParent() == null && root.checkIfLeaf()) {
			Node newRoot = new Node(1000, null);
			Node newNode = new Node(value, newRoot);
			root.setParent(newRoot);
			if (value < root.getKey()){
				newRoot.setLeftChild(newNode);
				newRoot.setMidChild(root);
			} else {
				newRoot.setLeftChild(root);
				newRoot.setMidChild(newNode);
			}
			newNode.updateNumElement();
			root.updateNumElement();
			newRoot.updateNumElement();
			root = newRoot;
		} else {
			Node parent = searchNode(value, root, 0, true, false).getParent();
			parent.setKey(1000);
			Node newNode = new Node(value, parent);
			if (!parent.hasRightChild()){ // Only 2 child
				if (value <= parent.getMinValue()){
					parent.setRightChild(parent.getMidChild());
					parent.setMidChild(parent.getLeftChild());
					parent.setLeftChild(newNode);
				} else {
					if (value <= parent.getMaxValue()){
						parent.setRightChild(parent.getMidChild());
						parent.setMidChild(newNode);
					} else {
						parent.setRightChild(newNode);
					}
				}
			} else { // Need Split
				if (value <= parent.getMinValue()){
					splitUp(parent, newNode, parent.getLeftChild(), parent.getMidChild(), parent.getRightChild());
				} else {
					if (value <= parent.getMaxValue()){
						splitUp(parent, parent.getLeftChild(), newNode, parent.getMidChild(), parent.getRightChild());
					} else {
						if (value <= parent.getRightChild().getKey()){
							splitUp(parent, parent.getLeftChild(), parent.getMidChild(), newNode, parent.getRightChild());
						} else {
							splitUp(parent, parent.getLeftChild(), parent.getMidChild(), parent.getRightChild(), newNode);
						}
					}
				}
			}
			newNode.updateNumElement();
			while (parent != null){
				parent.updateNumElement();
				parent = parent.getParent();
			}
		}
		
	}
	public void splitUp(Node node, Node first, Node second, Node third, Node fourth){
		Node nodeSplit = new Node(1000, null);
		node.setLeftChild(first);
		node.setMidChild(second);
		node.setRightChild(null);
		nodeSplit.setLeftChild(third);
		nodeSplit.setMidChild(fourth);
		nodeSplit.setRightChild(null);
		third.setParent(nodeSplit);
		fourth.setParent(nodeSplit);
		node.updateNumElement();
		nodeSplit.updateNumElement();
		if (node.getParent() == null){
			Node newRoot = new Node(1000, null);
			newRoot.setLeftChild(node);
			newRoot.setMidChild(nodeSplit);
			root = newRoot;
			node.setParent(root);
			nodeSplit.setParent(root);
			root.updateNumElement();
		} else {
			Node parent = node.getParent();
			parent.updateNumElement();
			if (!parent.hasRightChild()){
				if (node == parent.getLeftChild()){
					parent.setRightChild(parent.getMidChild());
					parent.setMidChild(nodeSplit);
					parent.setLeftChild(node);
				} else {
					parent.setRightChild(nodeSplit);
					parent.setMidChild(node);
				}
				nodeSplit.setParent(parent);
			} else {
				if (node == parent.getLeftChild()){
					splitUp(parent, parent.getLeftChild(), nodeSplit, parent.getMidChild(), parent.getRightChild());
				} else if (node == parent.getMidChild()){
					splitUp(parent, parent.getLeftChild(), parent.getMidChild(), nodeSplit, parent.getRightChild());
				} else {
					splitUp(parent, parent.getLeftChild(), parent.getMidChild(), parent.getRightChild(), nodeSplit);
				}
			}
			parent.updateNumElement();

		}

	}
	public void deleteNode(int value){
		Node del = searchNode(value, root, 0, false, true);
		Node parent = del.getParent();
		if (del == root){ // del is root
			del = null;
		} else if (parent.hasRightChild()){ // parent of del has three children
			del = null;
			if (del == parent.getLeftChild()){
				parent.setLeftChild(parent.getMidChild());
				parent.setMidChild(parent.getRightChild());
				parent.setRightChild(null);
			} else if (del == parent.getMidChild()){
				parent.setMidChild(parent.getRightChild());
				parent.setRightChild(null);
			} else {
				parent.setRightChild(null);;
			}
			while (parent != null){
				parent.updateNumElement();
				parent = parent.getParent();
			}
		} else{ // parent of del has two children
			if (parent == root){ // parent of del is root
				Node newRoot;
				if (del == parent.getLeftChild()){
					newRoot = parent.getMidChild();
				} else {
					newRoot = parent.getLeftChild();
				}
				del = null;
				parent = null;
				root = newRoot;
				newRoot.updateNumElement();
			} else { // parent of del is not root
				Node grandParent = parent.getParent();
				Node sibling;
				if (parent == grandParent.getLeftChild()){ // If parent has right sibling
					sibling = grandParent.getMidChild();
					if (sibling.hasRightChild()){ // If sibling has three children
						if (del == parent.getLeftChild()){ // del is parent's left child
							parent.setLeftChild(parent.getMidChild());
							parent.setMidChild(sibling.getLeftChild());
							parent.updateNumElement();
							sibling.setLeftChild(sibling.getMidChild());
							sibling.setMidChild(sibling.getRightChild());
							sibling.setRightChild(null);
							while (sibling != null){
								sibling.updateNumElement();
								sibling = sibling.getParent();
							}
						} else {
							parent.setMidChild(sibling.getLeftChild());
							parent.updateNumElement();
							sibling.setLeftChild(sibling.getMidChild());
							sibling.setMidChild(sibling.getRightChild());
							sibling.setRightChild(null);
							while (sibling != null){
								sibling.updateNumElement();
								sibling = sibling.getParent();
							}
						}
					} else { // If sibling has two children
						if (del == parent.getLeftChild()){
							sibling.setRightChild(sibling.getMidChild());
							sibling.setMidChild(sibling.getLeftChild());
							sibling.setLeftChild(parent.getMidChild());
							del = null;
							parent.setMidChild(null);

						} else {
							sibling.setRightChild(sibling.getMidChild());
							sibling.setMidChild(sibling.getLeftChild());
							sibling.setLeftChild(parent.getLeftChild());
							del = null;
							parent.setLeftChild(null);
						}
						grandParent.setLeftChild(sibling);
						grandParent.setMidChild(null);
						while (sibling != null){
							sibling.updateNumElement();
							sibling = sibling.getParent();
						}
					}
				} else { // If parent has left sibling
					if (parent == grandParent.getMidChild()){
						sibling = grandParent.getLeftChild();
					} else {
						sibling = grandParent.getMidChild();
						
					}
					if (sibling.hasRightChild()){ // If sibling has three children
						if (del == parent.getLeftChild()){ // del is parent's left child
							parent.setLeftChild(sibling.getRightChild());
							parent.updateNumElement();
							sibling.getRightChild().setParent(parent);
							sibling.setRightChild(null);
							del = null;
							while (sibling != null){
								sibling.updateNumElement();
								sibling = sibling.getParent();
							}
						} else {
							parent.setMidChild(parent.getLeftChild());
							parent.setLeftChild(sibling.getRightChild());
							parent.updateNumElement();
							del = null;
							sibling.getRightChild().setParent(parent);
							sibling.setRightChild(null);
							while (sibling != null){
								sibling.updateNumElement();
								sibling = sibling.getParent();
							}
						}
					} else { // If sibling has two children
						if (del == parent.getLeftChild()){
							sibling.setRightChild(parent.getMidChild());
							parent.getMidChild().setParent(sibling);
							del = null;
							parent.setMidChild(null);
						} else {
							sibling.setRightChild(parent.getLeftChild());
							parent.getLeftChild().setParent(sibling);
							del = null;
							parent.setLeftChild(null);
						}
						if (parent == grandParent.getMidChild()){
							grandParent.setMidChild(grandParent.getRightChild());
						}
						grandParent.setRightChild(null);
						if (!grandParent.hasMidChild()) {
							Node greatGrandParent = grandParent.getParent();
							if (grandParent == root){
								root = sibling;
								sibling.setParent(null);
							} else if (grandParent == greatGrandParent.getLeftChild()){
								greatGrandParent.setLeftChild(sibling);	
								sibling.setParent(greatGrandParent);
							} else if (grandParent == greatGrandParent.getMidChild()){
								greatGrandParent.setMidChild(sibling);	
								sibling.setParent(greatGrandParent);
							} else {
								greatGrandParent.setRightChild(sibling);	
								sibling.setParent(greatGrandParent);
							}
						}
						while (sibling != null){
							sibling.updateNumElement();
							sibling = sibling.getParent();
						}
					}
				}
			}
		}
	}
	public Node selectNode(int k, Node node) {
		Node selected = node;
		int numLeft = selected.getNumLeft();
		int numMid = selected.getNumMid();
		if (node.checkIfLeaf()){
			System.out.println(node.getKey());
			return node;
		} else if (numLeft + 1 > k){
			return selectNode(k, selected.getLeftChild());
		} else if (numLeft + numMid + 1 > k){
			return selectNode(k - numLeft, selected.getMidChild());
		} else {
			return selectNode(k - numLeft - numMid, selected.getRightChild());
		}
	}
	public void printOut(Node node) {
		if (node.checkIfLeaf()){
			System.out.print(" " + node.getKey());
		} else {
			printOut(node.getLeftChild());
			printOut(node.getMidChild());
			if (node.hasRightChild())
				printOut(node.getRightChild());
			
		}
	}
	
}
