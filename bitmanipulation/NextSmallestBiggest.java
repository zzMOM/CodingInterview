package bitmanipulation;

public class NextSmallestBiggest {
	public void getNextBiggest(int n){// n = 11011001111100
		int c = n;
		int c0 = 0;
		int c1 = 0;
		System.out.println("n:" + Integer.toBinaryString(n));
		//get continues "0" on the end
		while(((c & 1) == 0) && (c != 0)){
			c0++;
			c >>= 1;
			System.out.println("c:" + Integer.toBinaryString(c));
		}
		System.out.println("c0:" + Integer.toBinaryString(c0));// c = 110110011111, c0 = 2;2-continues "0"
		
		//get continues "1" on the end
		while((c & 1) == 1){
			c1++;
			c >>= 1;
			System.out.println("c:" + Integer.toBinaryString(c));
		}
		System.out.println("c1:" + Integer.toBinaryString(c1));//c = 1101100, c1 = 5;5-continues"1"
		
		/*
		 * if n == 11...1100..00, no bigger number with the same number of 1s
		 */
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return;
		}
		
		int p = c0 + c1;//rightmost non-trailing zeros, p = 7
		System.out.println("p:" + Integer.toBinaryString(p));
		
		n |= (1 << p);//Flip the "0" in position p to "1"; n = 11011011111100
		System.out.println("n:" + Integer.toBinaryString(n));
		n &= ~((1 << p) - 1);//clear all the bits to the right to p; n = 11011010000000
		System.out.println("n:" + Integer.toBinaryString(n));
		n |=(1 << (c1 - 1)) - 1;// insert (c1-1) 1s on the right n = 11011010001111
		System.out.println("n:" + Integer.toBinaryString(n));
	}
	
	public void getNextSmallest(int n){
		int c = n;
		int c0 = 0;
		int c1 = 0;
		System.out.println("n:" + Integer.toBinaryString(n));
		
		while((c & 1) == 1){
			c1++;
			c >>= 1;
		}
		
		if(c == 0) return;
		
		while(((c & 1) == 0) && (c != 0)){
			c0++;
			c >>= 1;
		}
		
		int p = c0 + c1; //position of rightmost non-trailing one
		n &= ((~0) << (p+1));//clear from bit p onwards
		int mask = (1 << (c1 + 1)) - 1; //sequence of (c1 + 1) ones
		n |= mask << (c0 - 1);
		System.out.println("n:" + Integer.toBinaryString(n));
	}
}
