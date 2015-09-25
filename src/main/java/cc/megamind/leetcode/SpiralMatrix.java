package cc.megamind.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 2, 3 }};
		System.out.println(spiralOrder(matrix));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
        if(matrix.length == 0) {
            return result;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        
         while(up<=down && left<=right) {
            int j=left;
            int i=up;
            
            // go right;
            for(j=left; j<=right; j++) {
                result.add(matrix[i][j]);
            }
            j--;
            up ++;
            
            // go down;
            for(i=up; i<=down; i++) {
                result.add(matrix[i][j]);
            }
            i--;
            right --;
            
            // go left;
            for(j=right; j>=left; j--){
                result.add(matrix[i][j]);
            }
            j++;
            down --;
            
            // go up;
            for(i=down; i>=up; i--) {
                result.add(matrix[i][j]);
            }
            i++;
            left++;
        }
        return result;
    }
}
