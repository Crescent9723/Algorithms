package dataStructure.queue;

import dataStructure.application.DataStructure;

public class Queue<T> implements DataStructure {
	Node front, back;
	int size = 0;
	class Node {
		T data;
		Node next;
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public Queue(){
		front = null;
		back = null;
		size = 0;
	}
	
	public void enqueue(T data){
		Node newNode = new Node(data, null);
		if (size == 0){
			front = newNode;
			back = newNode;
			size++;
			return;
		}
		back.next = newNode;
		back = newNode;
		size++;
		System.out.println("Enqueued " + data);
	}
	
	public T dequeue(){
		if (size == 0){
			System.out.println("Queue is empty");
			return null;
		}
		T data = front.data;
		front = front.next;
		size--;
		System.out.println("Dequeued " + data);
		return data;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public void printCurrentData() {
		Node temp = front;
		while (temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
}
