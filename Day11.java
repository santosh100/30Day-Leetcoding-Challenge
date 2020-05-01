/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Info{
    int height;
    int diameter;
}

class Solution {
    public static Info helper(TreeNode root){
        if(root == null){
            return new Info();
        }
        if(root.left == null && root.right == null){
            Info ob = new Info();
            ob.height = 1;
            ob.diameter = 0;
            return ob;                    	
        }
        
        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);
        
        int height = 1 + Math.max(leftInfo.height,rightInfo.height);        
        int diameter = Math.max(leftInfo.diameter,rightInfo.diameter);
        int newDiameter = leftInfo.height+rightInfo.height;
        
        Info ob = new Info();
        ob.height = height;
    	ob.diameter = Math.max(diameter,newDiameter);
        return ob;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
    }
}