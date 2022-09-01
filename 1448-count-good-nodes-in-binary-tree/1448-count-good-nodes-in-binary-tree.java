class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root,-50000);
        return count;
    }
    public void helper(TreeNode root , int max){
        if(root==null){
            return ;
        }
        max=Math.max(root.val,max);
        if(root.val>=max)count++;
        helper(root.left,max);
        helper(root.right,max);
        return ;
    }
}