// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.
// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // Sort array
        Arrays.sort(nums);

        int total = 1;
        int runningCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                runningCount++;
                if (runningCount > total) {
                    total = runningCount;
                }
            } else if (nums[i] != nums[i - 1]) {
                // Only reset if it's not a duplicate
                runningCount = 1;
            }
        }

        return total;
    }
}