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
		//rd.deleteDups2(strLinkedList.getHead());
		
		//KtoLastElem
		KtoLastElem kle = new KtoLastElem();
		kle.ktoLast1(strLinkedList.getHead(), 6);
		Node k = kle.ktoLast3(strLinkedList.getHead(), 6);
		System.out.print(k.elem.toString());
	}

}
