// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0; // No trapped water with less than 3 bars
        
        int left = 0;
        int right = n - 1;
        int leftMax = height[left]; // Initialize leftMax as the height of the leftmost bar
        int rightMax = height[right]; // Initialize rightMax as the height of the rightmost bar
        int trappedWater = 0; // Initialize the trappedWater counter

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left]; // Update leftMax if a higher bar is found
                } else {
                    trappedWater += leftMax - height[left]; // Calculate trapped water on the left
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right]; // Update rightMax if a higher bar is found
                } else {
                    trappedWater += rightMax - height[right]; // Calculate trapped water on the right
                }
                right--;
            }
        }

        return trappedWater; // Return the total trapped water
    }
}
