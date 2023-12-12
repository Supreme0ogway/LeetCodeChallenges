// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
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
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the root is null, there can't be any subtree
        if (root == null) {
            return false;
        }

        // Check if the current subtree is equal to subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Recursively check in the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one of the trees is null and the other is not, they are different
        if (p == null || q == null) {
            return false;
        }

        // Check if the current nodes have the same value
        if (p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}