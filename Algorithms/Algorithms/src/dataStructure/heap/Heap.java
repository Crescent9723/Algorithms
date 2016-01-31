package dataStructure.heap;

import java.lang.reflect.Array;

import dataStructure.application.DataStructure;

@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> implements DataStructure {
	T[] arr = null;
	int maxSize = 20;
	int numElements = 0;
	Class<T> type;
	public Heap(Class<T> type){
		this.type = type;
		arr = ((T[]) Array.newInstance(type, maxSize));
		numElements = 0;
	}
	
	public void insert(T data){
		if (numElements > maxSize){
			maxSize *= 2;
			T[] temp = arr;
			arr = ((T[]) Array.newInstance(type, maxSize));
			for (int i = 0 ; i < numElements; i++){
				arr[i] = temp[i];
			}
		}
		arr[numElements] = data;
		bubbleUp(numElements);
		numElements++;
		System.out.println("Inserted: " + data);
	}
	
	public T delete(){
		if (numElements == 0){
			return null;
		}
		T data = arr[0];
		arr[0] = arr[numElements-1];
		arr[numElements-1] = null;
		numElements--;
		bubbleDown(0);
		System.out.println("Deleted: " + data);
		return data;
	}
	
	private void bubbleUp(int index){
		int parent = (index-1)/2;
		if (index > 0 && arr[parent].compareTo(arr[index]) < 0){
			T temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
			bubbleUp(parent);
		}
	}
	
	private void bubbleDown(int index){
		int first = (index * 2) + 1;
		if (first >= numElements){
			return;
		}
		int second = (index * 2) + 2;
		if (second >= numElements){
			return;
		}
		T temp = arr[index];
		if (arr[first].compareTo(arr[second]) > 0)
		{
			arr[index] = arr[first];
			arr[first] = temp;
			bubbleDown(first);
		}
		else
		{
			arr[index] = arr[second];
			arr[second] = temp;
			bubbleDown(second);
		}
	}
	@Override
	public void printCurrentData() {
		for (int i = 0 ; i < numElements; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
