package chapter1;

/**
 * 
 * 1 1 Implement an algorithm to determine if a string has all unique characters What if 
you can not use additional data structures?
 *
 *For simplicity, assume char set is ASCII (if not, we need to increase the storage size The rest 
of the logic would be the same) NOTE: This is a great thing to point out to your interviewer!
 */
public class UniqueCharacters {
	
	//worst case1: Compare every character of the string to every other character of the string.
	//This will take O(N^2) time, and O(1) space.
	
	//If we are allowed to modify the input string, we can sort the string first, O(nlog(n)) time for sorting.
	//And then linearly check the string for neighboring characters.
	
	//This method uses the hash table idea, hash table search time is O(n), space O(1)
	//char array
	public boolean isUniqueChars1(String str){
		if(str.length() > 256) return false;
		
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}

	//Use bit vector to reduce the space usage, time O(n), space O(1)
	//single int array
	public boolean isUniqueChars2(String str){
		if(str.length() > 256) return false;
		
		int check = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((check & (1 << val)) > 0) return false;
			check |= (1 << val);
		}
		return true;
	}
}
