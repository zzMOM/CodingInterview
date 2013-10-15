package chapter2;

public class LinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int counter = 0;
	
	public LinkedList(){
	}
	
	public int size(){
		return counter;
	}
	
	public void addAtEnd(E elem){
		if(head == null){
			head = tail = new Node(elem);
			head.elem = elem;
			head.next = tail;
			tail = head;
		} else {
			tail.next = new Node(elem);
			tail = tail.next;
			tail.elem = elem;
		}
		counter++;
	}
	
	
}
