class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root,-50000);
        return count;
    }
    public int helper(TreeNode root , int max){
        if(root==null){
            return 0;
        }
        max=Math.max(root.val,max);
        if(root.val>=max)count++;
        helper(root.left,max);
        helper(root.right,max);
        // if(helper(root.left,max)>=max){
        //     count++;
        // }
        // if(helper(root.right,max)>=max){
        //     count++;
        // }
        return max;
    }
}