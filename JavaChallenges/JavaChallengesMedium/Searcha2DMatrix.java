// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

 

// Example 1:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //first look through rows if target > row start then go down
        //using split find the num

        int row = 0;
        for(int i = 1; i < matrix.length; i++) {
            int midRowNum = matrix[i][0];
            if(midRowNum <= target) {
                row = i;
            } else {
                break;
            }
        }

        int start = 0;
        int end = matrix[row].length-1;
        while(start <= end) {
            int mid = start + ((end - start)/2);
            if(matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}