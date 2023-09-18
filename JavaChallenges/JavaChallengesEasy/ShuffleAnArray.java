// Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

// Implement the Solution class:

// Solution(int[] nums) Initializes the object with the integer array nums.
// int[] reset() Resets the array to its original configuration and returns it.
// int[] shuffle() Returns a random shuffling of the array.

class Solution {
    private int[] arr;
    private int[] newArr;

    public Solution(int[] nums) {
        arr = nums;
        newArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            newArr[i] = arr[i];
        }
    }
    
    public int[] reset() {
        for(int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    public int[] shuffle() {
        Random r = new Random();
        
         for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);//shuffles 2 numbers at once
            int temp = newArr[i];
            newArr[i] = newArr[j];
            newArr[j] = temp;
        }
        
        return newArr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */