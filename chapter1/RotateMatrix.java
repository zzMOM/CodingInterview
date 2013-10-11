package chapter1;

/**
 * 
 * 1 6 Given an image represented by an NxN matrix, where each pixel in the image is 4 
bytes, write a method to rotate the image by 90 degrees 
 *
 */
public class RotateMatrix {
	public void rotate(int[][] matrix, int n){
		for(int layer = 0; layer < n / 2; ++layer){
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i){
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
}
