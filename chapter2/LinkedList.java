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
			head = tail = new Node();
			head.elem = elem;
			head.next = tail;
			tail = head;
		} else {
			tail.next = new Node();
			tail = tail.next;
			tail.elem = elem;
		}
		counter++;
	}
	
	public Node<E> getHead(){
		return head;
	}
}
