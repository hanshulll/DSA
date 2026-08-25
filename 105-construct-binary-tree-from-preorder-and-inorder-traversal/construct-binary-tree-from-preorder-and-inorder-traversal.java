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
    Map<Integer, Integer> index = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++) {
            index.put(inorder[i],i);
        }
        return buildBinaryTree(preorder, 0, inorder.length-1);
    }

    private TreeNode buildBinaryTree(int[] preorder, int left, int right) {
        if(left>right) {
            return null;
        }
        int val = preorder[preorderIndex++];
        TreeNode node = new TreeNode(val);
        int mid = index.get(val);
        node.left = buildBinaryTree(preorder, left, mid-1);
        node.right = buildBinaryTree(preorder,mid+1,right);
        return node;
    }
}