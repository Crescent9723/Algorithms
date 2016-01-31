package dataStructure.TwoThreeTree;

public class Node {
	
	//Variables
	private int maxValue;
	private int minValue;
	private int key;
	private int numLeft;
	private int numMid;
	private int numRight;
	private int numElement;
	private Node parent;
	private Node leftChild;
	private Node midChild;
	private Node rightChild;
	
	//Constructors
	public Node(int key, Node parent){
		this.setKey(key);
		this.setParent(parent);
		this.setLeftChild(null);
		this.setMidChild(null);
		this.setRightChild(null);
		this.setMinValue(key);
		this.setMaxValue(key);
		this.setNumLeft(0);
		this.setNumMid(0);
		this.setNumRight(0);
		this.setNumElement(1);
	}
	
	//Setters
	public void setNumLeft(int numLeft) {
		this.numLeft = numLeft;
	}
	public void setNumMid(int numMid) {
		this.numMid = numMid;
	}
	public void setNumRight(int numRight) {
		this.numRight = numRight;
	}
	public void setNumElement(int numElement) {
		this.numElement = numElement;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null){
			setMinValue(leftChild.getMaxValue());
			this.leftChild.setParent(this);
		}
		updateNumElement();
	}
	public void setMidChild(Node midChild) {
		this.midChild = midChild;
		if (midChild != null){
			setMaxValue(midChild.getMaxValue());
			this.midChild.setParent(this);
		}
		updateNumElement();
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null){
			this.rightChild.setParent(this);
		}
		updateNumElement();
	}
	
	//Getters
	public int getMaxValue() {
		return maxValue;
	}
	public int getMinValue() {
		return minValue;
	}
	public int getKey() {
		return key;
	}
	public Node getParent() {
		return parent;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public Node getMidChild() {
		return midChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public int getNumLeft() {
		return numLeft;
	}
	public int getNumMid() {
		return numMid;
	}
	public int getNumRight() {
		return numRight;
	}
	public int getNumElement() {
		return numElement;
	}

	//Check conditions
	public boolean checkIfLeaf() {
		if (leftChild == null){
			return true;
		}
		return false;
	}
	public boolean hasRightChild() {
		if (rightChild == null)
			return false;
		else
			return true;
	}
	public boolean hasMidChild() {
		if (midChild == null)
			return false;
		else
			return true;
	}

	//Update Data
	public void updateNumElement() {
		if (checkIfLeaf()){
			this.numElement = 1;
		} else {
			this.setNumLeft(this.getLeftChild().getNumElement());
			this.numElement = this.getNumLeft();
			if (hasMidChild()){
				this.setNumMid(this.getMidChild().getNumElement());
				this.numElement += this.getNumMid();
			}
			if (hasRightChild()){
				this.setNumRight(this.getRightChild().getNumElement());
				this.numElement += this.getNumRight();
			}
		}
	}

}
