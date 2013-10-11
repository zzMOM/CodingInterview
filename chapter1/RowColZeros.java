package chapter1;
import java.util.BitSet;

/**
 * 1 7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and 
column is set to 0 
 *
 */
public class RowColZeros {
	public void setZeros1(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(row[i] || column[j]){
					matrix[i][j] = 0;
				}
			}
		}
		
		System.out.println(matrix);
	}
	
	//use bit vector to make space efficient
	public void setZeros2(int[][] matrix){
		BitSet bitset1 = new BitSet(matrix.length);
		BitSet bitset2 = new BitSet(matrix[0].length);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					bitset1.set(1);
					bitset2.set(1);
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(bitset1.get(i) || bitset2.get(j)){
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println(matrix);
	}
}
