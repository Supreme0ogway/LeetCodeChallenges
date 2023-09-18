// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Use a HashMap to count the occurrences of elements in nums1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the intersection elements and their counts in nums2
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                intersection.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        // Convert the List to an array and return
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}