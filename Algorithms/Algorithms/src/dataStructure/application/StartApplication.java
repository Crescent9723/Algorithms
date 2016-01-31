package dataStructure.application;
import java.io.IOException;
import java.util.Scanner;

import bst.BinarySearchTree;
import heap.Heap;
import queue.Queue;
import stack.Stack;

public class StartApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		DataStructure dataStructure = null;
		char input = 0;
		Object dataType = null;
		String control = null;
		System.out.println("Please Enter the data type you want to work on (Integer: i, Double: d, String: s, Character: c): ");
		input = (char) scan.next().charAt(0);
		switch (input){
		case 'i':	dataType = new Integer(0);	break;
		case 'd':	dataType = new Double(0);	break;
		case 's':	dataType = new String();	break;
		case 'c':	dataType = new Character('a');	break;
		}
		System.out.println("Please Enter the data structure you want to work on (Stack: s, Queue: q, BST: b, Heap: h): ");
		input = (char) scan.next().charAt(0);
		switch (input){
		case 's':
			if (dataType instanceof Integer){
				dataStructure = new Stack<Integer>();
			} else if (dataType instanceof Double){
				dataStructure = new Stack<Double>();
			} else if (dataType instanceof String){
				dataStructure = new Stack<String>();
			} else if (dataType instanceof Character){
				dataStructure = new Stack<Character>();
			}
			break;
		case 'q':
			if (dataType instanceof Integer){
				dataStructure = new Queue<Integer>();
			} else if (dataType instanceof Double){
				dataStructure = new Queue<Double>();
			} else if (dataType instanceof String){
				dataStructure = new Queue<String>();
			} else if (dataType instanceof Character){
				dataStructure = new Queue<Character>();
			}
			break;
		case 'b':
			if (dataType instanceof Integer){
				dataStructure = new BinarySearchTree<Integer>();
			} else if (dataType instanceof Double){
				dataStructure = new BinarySearchTree<Double>();
			} else if (dataType instanceof String){
				dataStructure = new BinarySearchTree<String>();
			} else if (dataType instanceof Character){
				dataStructure = new BinarySearchTree<Character>();
			}
			break;
		case 'h':
			if (dataType instanceof Integer){
				dataStructure = new Heap<Integer>(Integer.class);
			} else if (dataType instanceof Double){
				dataStructure = new Heap<Double>(Double.class);
			} else if (dataType instanceof String){
				dataStructure = new Heap<String>(String.class);
			} else if (dataType instanceof Character){
				dataStructure = new Heap<Character>(Character.class);
			}
			break;
		}
		control = scan.nextLine();
		while (true){
			if (dataStructure instanceof Stack){
				System.out.println("Please Enter the action you want to perform (push, pop, peek, print, quit): ");
				control = scan.nextLine();
				if (control.equals("push")){
					System.out.println("Please enter data to add:");
					String data = scan.nextLine();
					if (dataType instanceof Integer){
						((Stack<Integer>) dataStructure).push(Integer.parseInt(data));
					} else if (dataType instanceof Double){
						((Stack<Double>) dataStructure).push(Double.parseDouble(data));
					} else if (dataType instanceof String){
						((Stack<String>) dataStructure).push(data);
					} else if (dataType instanceof Character){
						((Stack<Character>) dataStructure).push(data.charAt(0));
					}
				} else if (control.equals("pop")){
					if (dataType instanceof Integer){
						((Stack<Integer>) dataStructure).pop();
					} else if (dataType instanceof Double){
						((Stack<Double>) dataStructure).pop();
					} else if (dataType instanceof String){
						((Stack<String>) dataStructure).pop();
					} else if (dataType instanceof Character){
						((Stack<Character>) dataStructure).pop();
					}
				} else if (control.equals("peek")){
					if (dataType instanceof Integer){
						((Stack<Integer>) dataStructure).peek();
					} else if (dataType instanceof Double){
						((Stack<Double>) dataStructure).peek();
					} else if (dataType instanceof String){
						((Stack<String>) dataStructure).peek();
					} else if (dataType instanceof Character){
						((Stack<Character>) dataStructure).peek();
					}
				} else if (control.equals("print")){
					dataStructure.printCurrentData();
				} else if (control.equals("quit")){
					break;
				} else {
					System.out.println("Wrong input");
					continue;
				}
			} else if (dataStructure instanceof Queue){
				System.out.println("Please Enter the action you want to perform (enqueue, dequeue, print, quit): ");
				control = scan.nextLine();
				if (control.equals("enqueue")){
					System.out.println("Please enter data to add:");
					String data = scan.nextLine();
					if (dataType instanceof Integer){
						((Queue<Integer>) dataStructure).enqueue(Integer.parseInt(data));
					} else if (dataType instanceof Double){
						((Queue<Double>) dataStructure).enqueue(Double.parseDouble(data));
					} else if (dataType instanceof String){
						((Queue<String>) dataStructure).enqueue(data);
					} else if (dataType instanceof Character){
						((Queue<Character>) dataStructure).enqueue(data.charAt(0));
					}
				} else if (control.equals("dequeue")){
					if (dataType instanceof Integer){
						((Queue<Integer>) dataStructure).dequeue();
					} else if (dataType instanceof Double){
						((Queue<Double>) dataStructure).dequeue();
					} else if (dataType instanceof String){
						((Queue<String>) dataStructure).dequeue();
					} else if (dataType instanceof Character){
						((Queue<Character>) dataStructure).dequeue();
					}
				} else if (control.equals("print")){
					dataStructure.printCurrentData();
				} else if (control.equals("quit")){
					break;
				} else {
					System.out.println("Wrong input");
					continue;
				}
			} else if (dataStructure instanceof BinarySearchTree){
				System.out.println("Please Enter the action you want to perform (insert, delete, search, print, quit): ");
				control = scan.nextLine();
				if (control.equals("insert")){
					System.out.println("Please enter data to add:");
					String data = scan.nextLine();
					if (dataType instanceof Integer){
						((BinarySearchTree<Integer>) dataStructure).insert(Integer.parseInt(data));
					} else if (dataType instanceof Double){
						((BinarySearchTree<Double>) dataStructure).insert(Double.parseDouble(data));
					} else if (dataType instanceof String){
						((BinarySearchTree<String>) dataStructure).insert(data);
					} else if (dataType instanceof Character){
						((BinarySearchTree<Character>) dataStructure).insert(data.charAt(0));
					}
				} else if (control.equals("delete")){
					System.out.println("Please enter data to delete:");
					String data = scan.nextLine();
					if (dataType instanceof Integer){
						((BinarySearchTree<Integer>) dataStructure).delete(Integer.parseInt(data));
					} else if (dataType instanceof Double){
						((BinarySearchTree<Double>) dataStructure).delete(Double.parseDouble(data));
					} else if (dataType instanceof String){
						((BinarySearchTree<String>) dataStructure).delete(data);
					} else if (dataType instanceof Character){
						((BinarySearchTree<Character>) dataStructure).delete(data.charAt(0));
					}
				} else if (control.equals("search")){
					System.out.println("Please enter data to search:");
					String data = scan.nextLine();
					if (dataType instanceof Integer){
						((BinarySearchTree<Integer>) dataStructure).search(Integer.parseInt(data));
					} else if (dataType instanceof Double){
						((BinarySearchTree<Double>) dataStructure).search(Double.parseDouble(data));
					} else if (dataType instanceof String){
						((BinarySearchTree<String>) dataStructure).search(data);
					} else if (dataType instanceof Character){
						((BinarySearchTree<Character>) dataStructure).search(data.charAt(0));
					}
				} else if (control.equals("print")){
					dataStructure.printCurrentData();
				} else if (control.equals("quit")){
					break;
				} else {
					System.out.println("Wrong input");
					continue;
				}
			} else if (dataStructure instanceof Heap){
				System.out.println("Please Enter the action you want to perform (insert, delete, print, quit): ");
				control = scan.nextLine();
				if (control.equals("insert")){
					System.out.println("Please enter data to add:");
					String data = scan.nextLine();
					if (dataType instanceof Integer){
						((Heap<Integer>) dataStructure).insert(Integer.parseInt(data));
					} else if (dataType instanceof Double){
						((Heap<Double>) dataStructure).insert(Double.parseDouble(data));
					} else if (dataType instanceof String){
						((Heap<String>) dataStructure).insert(data);
					} else if (dataType instanceof Character){
						((Heap<Character>) dataStructure).insert(data.charAt(0));
					}
				} else if (control.equals("delete")){
					if (dataType instanceof Integer){
						((Heap<Integer>) dataStructure).delete();
					} else if (dataType instanceof Double){
						((Heap<Double>) dataStructure).delete();
					} else if (dataType instanceof String){
						((Heap<String>) dataStructure).delete();
					} else if (dataType instanceof Character){
						((Heap<Character>) dataStructure).delete();
					}
				} else if (control.equals("print")){
					dataStructure.printCurrentData();
				} else if (control.equals("quit")){
					break;
				} else {
					System.out.println("Wrong input");
					continue;
				}
			}
		}
		scan.close();
	}

}
