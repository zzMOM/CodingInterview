package chapter1;
/**
 * 
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * aabcccccaaa compressed to a2b1c5a3.
 * If the copressed string would not become smaller than the origianl string, you method should return the original string.
 *
 */
public class CompressStrings {
	
	//running time too long 
	//O(n + m^2) n is the string length, m is the number of character sequences 
	public String compressBad(String str){
		if(str.length() == 0){
			return str;
		}
		
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			} else {
				mystr += last + "" + count;//without "", myster will be integer
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr += last + "" + count;
		
		if(mystr.length() >= str.length()){
			return str;
		} else {
			return mystr;
		}
	}
	
	public String compressBetter(String str){
		if(str.length() == 0){
			return str;
		}
		
		int size = countCompression(str);
		if(size >= str.length()){
			return str;
		}
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}
	
	int countCompression(String str){
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public String compressAlternate(String str){
		if(str.length() == 0){
			return str;
		}
		
		int size = countCompression(str);
		if(size >= str.length()){
			return str;
		}
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	int setChar(char[] array, char c, int index, int count){
		array[index] = c;
		index++;
		
		char[] cnt = String.valueOf(count).toCharArray();
		for(char x : cnt){
			array[index] = x;
			index++;
		}
		return index;
	}
}
