package chapter1;

public class UniqueCharacters {
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
