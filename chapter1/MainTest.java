package chapter1;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UniqueCharacter
		String str = "abcdefga";
		UniqueCharacters uc = new UniqueCharacters();
		boolean method1 = uc.isUniqueChars1(str);
		boolean method2 = uc.isUniqueChars2(str);
		
		//PermutationString
		String s = "aaaaaaafffffffffdrftgfr";
		String t = "aafdffftrfaaffaaffgfraf";
		PermutationStrings ps = new PermutationStrings();
		boolean m1 = ps.permutation1(s, t);
		boolean m2 = ps.permutation2(s, t);
		
		//ReplaceSpaceString
		String charStr = "a b c   d ffgh     dfeald  jo ";
		char[] cStr = new char[charStr.length() * 3];
		for(int i = 0; i < charStr.length(); i++){
			cStr[i] = charStr.charAt(i);
		}
		ReplaceSpaceString rss = new ReplaceSpaceString();
		cStr = rss.replaceSpace1(cStr, charStr.length());
		charStr = rss.replaceSpace2(charStr, charStr.length());
		
		//CompressStrings
		String cs1 = "aaabbbbbbdddddddeefsgggggggggfffffjjjjjeeeeeeeeeeeeekekekekeksjjjjjmmmmaaaaammm";
		String cs2 = "";
		String cs3 = "a";
		String cs4 = "abcdefghijklmn";
		String cs5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String cs6 = "daaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		CompressStrings cs = new CompressStrings();
		/*System.out.println("string: " + cs1);
		System.out.println("Bad" + "  " + cs.compressBad(cs1));
		System.out.println("Better" + "  " + cs.compressBetter(cs1));
		System.out.println("Alternate" + "  " + cs.compressAlternate(cs1));
		System.out.println("string: " + cs2);
		System.out.println("Bad" + "  " + cs.compressBad(cs2));
		System.out.println("Better" + "  " + cs.compressBetter(cs2));
		System.out.println("Alternate" + "  " + cs.compressAlternate(cs2));
		System.out.println("string: " + cs3);
		System.out.println("Bad" + "  " + cs.compressBad(cs3));
		System.out.println("Better" + "  " + cs.compressBetter(cs3));
		System.out.println("Alternate" + "  " + cs.compressAlternate(cs3));
		System.out.println("string: " + cs4);
		System.out.println("Bad" + "  " + cs.compressBad(cs4));
		System.out.println("Better" + "  " + cs.compressBetter(cs4));
		System.out.println("Alternate" + "  " + cs.compressAlternate(cs4));
		System.out.println("string: " + cs5);
		System.out.println("Bad" + "  " + cs.compressBad(cs5));
		System.out.println("Better" + "  " + cs.compressBetter(cs5));
		System.out.println("Alternate" + "  " + cs.compressAlternate(cs5));
		System.out.println("string: " + cs6);
		System.out.println("Bad" + "  " + cs.compressBad(cs6));
		System.out.println("Better" + "  " + cs.compressBetter(cs6));
		System.out.println("Alternate" + "  " + cs.compressAlternate(cs6));*/
		
		//RowColZeros
		int[][] matrix = new int[15][10];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = j - 2 * i;
			}
		}
		RowColZeros rcz = new RowColZeros();
		rcz.setZeros1(matrix);
		rcz.setZeros2(matrix);
		
		//RotationStrings
		RotationStrings rs = new RotationStrings();
		/*substring testing
		String mainStr ="staarting from herre";
		String s1 = "s";
		String s2 = "x";
		String s3 = "re";
		String s4 = "tar";
		String s5 = "here";
		System.out.println(rs.isSubstring2(mainStr, s1));
		System.out.println(rs.isSubstring2(mainStr, s2));
		System.out.println(rs.isSubstring2(mainStr, s3));
		System.out.println(rs.isSubstring2(mainStr, s4));
		System.out.println(rs.isSubstring2(mainStr, s5));*/
		/*check string rotation*/
		String sa = "waterbottle";
		String sb = "erbottlewat";
		System.out.println(rs.isRotation(sa, sb));
	}

}
