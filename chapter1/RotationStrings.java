package chapter1;

/**
 *1.8 Assume you have a method isSubstring which checks if one word is a substring of
 *another Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
 *only one call to isSubstring (i e , waterbottle is a rotation of erbottlewat)
 *
 */
public class RotationStrings {
	/**
	 *
	 * Java program to check String for SubString. isSubstring1
	 * demonstrate two ways to find if One String contains a particular word or not in Java.
	 * contains() and indexOf() method of String class is used to check SubString
	 * @author
	 */
	public boolean isSubstring1(String str, String subs){
		if(str.indexOf(subs) != -1){
			System.out.println(subs + " is the substring of " + str);
		} else {
			System.out.println(subs + " isn't the substring of " + str);
		}
		
		if(str.contains(subs)){
			return true;
		} else {
			return false;
		}
	}
	
	/*check substring without using any method*/
	public boolean isSubstring2(String str, String subs){
		char c = subs.charAt(0);
		int check = 0;
		for(int j = 0; j <= str.length() - subs.length(); j++){
			int temp = j + 1;
			if(str.charAt(j) == c && (str.length() - j) >= subs.length()){
				check = 1;
				for(int k = 1; k < subs.length(); k++){
					if(subs.charAt(k) != str.charAt(temp)){
						check = 0;
						break;
					} else {
						temp++;
					}
				} 
				if(check == 1){
					return true;
				}
			}
		}
		return false;
	}
	
	/*check string rotation*/
	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return isSubstring2(s1s1, s2);
		}
		return false;
	}
}
