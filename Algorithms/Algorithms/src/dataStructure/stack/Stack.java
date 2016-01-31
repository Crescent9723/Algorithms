package dataStructure.stack;

import dataStructure.application.DataStructure;

public class Stack<T> implements DataStructure {
	Node head;
	int size = 0;
	class Node {
		T data;
		Node next;
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public Stack(){
		head = null;
		size = 0;
	}
	
	public void push(T data){
		Node newNode = new Node(data, head);
		head = newNode;
		size++;
		System.out.println("Pushed " + data);
	}
	
	public T pop(){
		if (size == 0){
			System.out.println("Stack is empty");
			return null;
		}
		Node temp = head;
		head = head.next;
		size--;
		System.out.println("Popped " + temp.data);
		return temp.data;
	}
	
	public T peek(){
		System.out.println("Peek: " + head.data);
		return head.data;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public void printCurrentData() {
		Node temp = head;
		while (temp != null){
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println();
	}
	
}
