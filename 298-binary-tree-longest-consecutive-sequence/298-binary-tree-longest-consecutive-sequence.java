class Solution {
    int max=0;
    public int longestConsecutive(TreeNode root) {
        helper(root,root.val+1,0);
        return max+1;
    }
    public void helper(TreeNode root,int prevval,int cur){
        if(root==null){
            return ;
        }
        if(root.val==prevval){
            cur++;
        }else{
            cur=0;
        }
        max=Math.max(cur,max);
        helper(root.left,root.val+1,cur);
        helper(root.right,root.val+1,cur);
    }
}
