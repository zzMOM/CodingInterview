package chapter3;

public class ArrayToStack {
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1, -1, -1};
	
	public ArrayToStack(){
		
	};
	
	public void push(int stackNum, int value) throws Exception{
		//check if we have space
		if(stackPointer[stackNum] + 1 > stackSize)
			throw new Exception("out of space");
		
		//increment stack pointer and then update top value
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum] == -1){
			throw new Exception("Try to pop an empty stack.");
		}
		int value = buffer[absTopOfStack(stackNum)]; //get top
		buffer[absTopOfStack(stackNum)] = 0; //clear index
		stackPointer[stackNum]--;//decremetn pointer
		return value;
	}
	
	public int peek(int stackNum){
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}
	
	public boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
	
	public int absTopOfStack(int stackNum){
		return stackNum * stackSize + stackPointer[stackNum];
	}
}
