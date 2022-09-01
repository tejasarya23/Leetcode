class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,-50000);
    }
    public int helper(TreeNode root , int max){
        if(root==null){
            return 0;
        }
        max=Math.max(root.val,max);
        if(root.val>=max){
            return 1+helper(root.left,max)+helper(root.right,max);
        }else{
            return helper(root.left,max)+helper(root.right,max);
        }
    }
}