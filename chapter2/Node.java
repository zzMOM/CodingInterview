package chapter2;

public class Node<E> {
	E elem;
	Node<E> next;
	
	public Node(E elem){
		this.elem = elem;
		this.next = null;
	}
}
