// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // Initialize two arrays to store products to the left and right of each element
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        
        // Initialize the result array
        int[] result = new int[n];
        
        // Calculate left products
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        
        // Calculate right products
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        
        // Calculate the final result by combining left and right products
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        
        return result;
        // if(nums.length == 1) {
        //     return nums;
        // }

        
        // int[] newArr = new int[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     int total = 1;
        //     int temp = nums[i];
        //     nums[i] = 1;
        //     for(int j = 0; j < nums.length; j++) {
        //         total = total * nums[j];
        //     }
        //     newArr[i] = total;
        //     nums[i] = temp;
        // }
        // return newArr;
        // //set temp to i
        // //set i to 1
        // //nultiply every value in the array
        // //set new i value in new array to new milt val
        // //set i to temp
        // //increment i

    }
}