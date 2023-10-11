// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sizeBoth = nums1.length + nums2.length;
        int[] merged = new int[sizeBoth];
        int i = 0, j = 0, k = 0;

        //merge arrays O(n)
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        //add remaining nums into the array
        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        //calculate the median
        if (sizeBoth % 2 == 0) {
            int beforeMid = merged[(sizeBoth - 1) / 2];
            int afterMid = merged[sizeBoth / 2];
            return (beforeMid + afterMid) / 2.0;
        } else {
            return merged[sizeBoth / 2];
        }
    }
}