/* You are given two integer arrays nums1 and nums2, sorted in non-decreasing 
order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored i
nside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m 
elements denote the elements that should be merged, and the last n elements are set to 0 and should 
be ignored. nums2 has a length of n.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //move all nums1 elements to front
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            l.add(nums1[i]);
        }
        //add extra numbers
        for(int i = 0; i < nums1.length; i++) {
            try {
                l.get(i);
            } catch (Exception e) {
                l.add(0);
            }
        }
        
        for(int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
        
        //combine
        int count = 0;
        for(int i = m; i < nums1.length; i++) {
            if(nums1[i] == 0) {
                nums1[i] = nums2[count];
                count++;
            }
        }
        //sort
        int temp;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = i; j < nums1.length; j++) {
                if(nums1[i] > nums1[j]) {
                    temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}