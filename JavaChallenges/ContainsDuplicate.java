// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Example 2:
// Input: nums = [1,2,3,4]
// Output: false
// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i : nums) {
            if(s.contains(i)) {
                return true;
            }
            s.add(i);
        }
        return false;
    }
}



//second way of doing the same thing done later sep 1 2023

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            if(set.add(i)) {
                System.out.println(i);
            } else {
                return true;
            }
        }
        return false;
    }
}