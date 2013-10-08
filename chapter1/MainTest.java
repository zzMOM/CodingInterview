package chapter1;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdefga";
		UniqueCharacters uc = new UniqueCharacters();
		boolean method1 = uc.isUniqueChars1(str);
		boolean method2 = uc.isUniqueChars2(str);
		
		String s = "aaaaaaafffffffffdrftgfr";
		String t = "aafdffftrfaaffaaffgfraf";
		PermutationStrings ps = new PermutationStrings();
		boolean m1 = ps.permutation1(s, t);
		boolean m2 = ps.permutation2(s, t);
		System.out.print(m1 + " " + m2);
	}

}
