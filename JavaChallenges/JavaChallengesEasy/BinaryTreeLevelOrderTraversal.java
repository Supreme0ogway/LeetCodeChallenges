/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bl = new ArrayList<>();
        
        if(root == null) {
            return bl;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//adds to back
 
        while(!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = q.size();

            //left to rigth traversal
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();//ppulls from front head
                l.add(node.val);
                
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            bl.add(l);
        }
        return bl;
    }
}