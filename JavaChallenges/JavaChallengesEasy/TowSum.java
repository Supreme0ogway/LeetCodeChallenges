// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.
// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int f;
        int s;
        for(int i = 0; i < nums.length; i++) {
            f = nums[i];
            for(int j = i; j < nums.length; j++) {
                s = nums[j];
                if(j != i && f + s == target) {
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        return nums;
    }
}


//second attempt (better)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //have i and j. i is fixed j searches after i
        //check if i + j = target return [i,j]
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int total = nums[i] + nums[j];
                if(total == target) {
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        return nums;
    }
}