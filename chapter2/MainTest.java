package chapter2;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create Linked List
		String sampleStr = "Due to the nature of LinkedLists, there is no efficient indexing system.";
		LinkedList strLinkedList = new LinkedList();  
		char elem;
		for(int i = 0; i < sampleStr.length(); i++){
			elem = sampleStr.charAt(i);
			strLinkedList.addAtEnd(elem);
		}
		
		//RemoveDuplicates
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.deleteDups1(strLinkedList.getHead());
		
	}

}
