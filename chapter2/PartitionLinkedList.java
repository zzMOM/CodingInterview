package chapter2;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come 
 * before all nodes greater than or equal to x
 * @author weiwu
 *
 */
public class PartitionLinkedList {

	public Node partition(Node head,  char ch){//current node is head
		Node beforeStarter = null;
		Node beforeEnd = null;
		Node afterStarter = null;
		Node afterEnd = null;
		Node node = head;
		
		/*partition list */
		while(node != null){
			Node temp = node.next;
			node.next = null;
			if(node.elem.toString().charAt(0) < ch){
				//insert node into end of before list
				if(beforeStarter == null){
					beforeStarter = node;
					beforeEnd = beforeStarter;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				//insert node into end of after list
				if(afterStarter == null){
					afterStarter = node;
					afterEnd = afterStarter;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = temp;
		}
		
		if(beforeStarter == null){
			return afterStarter;
		}
		
		//Merge before list and after list
		beforeEnd.next = afterStarter;
		return beforeStarter;
	}
}
