package chapter1;

/**
 * 
 * 1.4 Write a method to replace all spaces in a string with %20.
 * Assume that the string has sufficient space at the end of the string to hold the additional characters,
 * and that they are given the true length of the strings.
 *
 */
public class ReplaceSpaceString {
	public char[] replaceSpace1(char[] str, int length){
		int spaceCount = 0, newLength, i = 0;
		for(i = 0; i < length; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for(i = length - 1; i >= 0; i--){
			if(str[i] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
		return str;
	}
	
	
	public String replaceSpace2(String str, int length){
		int spaceCount = 0, newLength;
		StringBuffer b = new StringBuffer();
		for(int i = 0; i < length - 1; i++){
			if(str.charAt(i) == ' '){
				b.append("%20");
			} else {
				b.append(str.charAt(i));
			}
		}
		return b.toString();
	}
}
