//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int ind = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[ind]);
        
        node.left = buildBST(nums, start, ind-1);
        node.right = buildBST(nums, ind+1, end);
        
        return node;
    }
}
