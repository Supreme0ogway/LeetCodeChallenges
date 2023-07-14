//Given an integer array nums, find the subarray with the largest sum, and return its sum.


class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {//get the length starts at 1 because already got 0
            currentSum = Math.max(nums[i], currentSum + nums[i]);//gets the current sum
            maxSum = Math.max(maxSum, currentSum);//gets the bigger of the last or the current
        }
        
        return maxSum;//returns max
    }
}