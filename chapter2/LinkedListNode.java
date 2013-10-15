package chapter2;

public class LinkedListNode<T> {
	private Node<T> head = null;
	private int counter = 0;
	
	public LinkedListNode(){
	}
	
	public int size(){
		return counter;
	}

}
