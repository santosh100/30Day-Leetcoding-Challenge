/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode helper(TreeNode root, int elem){
        if(root == null){
            return new TreeNode(elem);
        }
        if(elem < root.val){
            root.left = helper(root.left, elem);
        }else{
            root.right = helper(root.right, elem);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i=0; i<preorder.length; i++){
            root = helper(root, preorder[i]);
        }
        return root;
    }
}