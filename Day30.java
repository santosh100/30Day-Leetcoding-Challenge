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
    public boolean helper(TreeNode root, int[] arr, int index){
        if(root == null){
            if(index == arr.length){
                return true;
            }else{
                return false;
            }            
        }                
        
        if(index == arr.length-1 && (root.left != null || root.right != null)){
            return false;
        }
        
        if(root.val == arr[index]){
            if(helper(root.left, arr, index+1)== false){
                return helper(root.right, arr, index+1);
            }else{
                return true;
            }  
        }else{
            return false;
        }
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }
}