// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

 

// Example 1:


// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// Example 2:

// Input: root = [1,2]
// Output: 1

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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = calculateDiameter(root.left);
        int rightDepth = calculateDiameter(root.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

//ANOTHER SOLUCATION (SAME)

class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calcD(root);
        return diameter;
    }

    private int calcD(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int ld = calcD(root.left);
        int rd = calcD(root.right);

        diameter = Math.max(diameter, ld + rd);

        return Math.max(ld, rd) + 1;//always 1
    }
}