package bitmanipulation;

/*
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a 
method to set all bits between i and j in N equal to M (e g , M becomes a substring of 
N located at i and starting at j) 
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
 */
public class InsertMN {

	public void updateBits(int n, int m, int i, int j){
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		
		//all 1 integer
		int allOnes = ~0;
		System.out.println(Integer.toBinaryString(allOnes));
		
		//1s before position j, set to 0
		int left = allOnes << (j + 1);
		System.out.println(Integer.toBinaryString(left));
		
		//1s after position i, 
		int right = ((1 << i) - 1);
		System.out.println(Integer.toBinaryString(right));
		
		int mask = left | right;
		System.out.println(Integer.toBinaryString(mask));
		
		int n_cleared = n & mask;
		System.out.println(Integer.toBinaryString(n_cleared));
		int m_shifted = m << i;
		System.out.println(Integer.toBinaryString(m_shifted));
		
		int result = n_cleared | m_shifted;
		System.out.println(Integer.toBinaryString(result));
	}
}
