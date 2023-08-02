// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// *********************** get deapth of Search Tree**********************

//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
class Solution {
    public int maxDepth(TreeNode root) {
        return reST(root);
    }
    
    public int reST(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftd = reST(root.left);
            int rightd = reST(root.right);
            
            return Math.max(leftd, rightd) + 1;
        }
    }
}
