package chapter1;
import java.util.Arrays;

/**
 * 
 * 1.3 Given two strings, write a method to decide if one is a permutation of the other.
 * (Write a method to decide if two strings are anagrams or not)
 * case sensitive???
 * white space is significant????
 * 
 * The solutions assume that case sensitive and whitespace is significant.
 *
 */
public class PermutationStrings {
	
	//solution #1: two sorting and one compare, time O(nlog(n)), space no extra space
	public String sort(String s){
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation1(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	
	
	//solution #2: time O(n), space 2 extra array[256]
	public boolean permutation2(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		int[] letters = new int[256];
		
		char[] s_array = s.toCharArray();
		for(char c : s_array){
			letters[c]++;
		}
		
		for(int i = 0; i < t.length(); i++){
			int c = (int)t.charAt(i);
			if(--letters[c] < 0){
				return false;
			}
		}
		return true;
	}
}
