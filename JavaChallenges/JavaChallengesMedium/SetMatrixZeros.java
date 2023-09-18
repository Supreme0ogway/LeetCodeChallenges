// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1


class Solution {
    public void setZeroes(int[][] matrix) {
        int numOfCol = matrix[0].length;
        //List<Integer> colWithZero = new ArrayList<>();
        Set<Integer> colWithZero = new HashSet<>();
        Set<Integer> rowWithZero = new HashSet<>();
        
        //if 0 in row make whole row 0
        //if 0 in col adj place in all columns
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    colWithZero.add(j);
                    rowWithZero.add(i);
                }
            }
        }
        
        int numOfRows = matrix.length;
        int numOfCols = matrix[0].length;
        
        // Set elements in rows with zeros to zero
        for (int i : rowWithZero) {
            for (int j = 0; j < numOfCols; j++) {
                matrix[i][j] = 0;
            }
        }

        // Set elements in columns with zeros to zero
        for (int j : colWithZero) {
            for (int i = 0; i < numOfRows; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}