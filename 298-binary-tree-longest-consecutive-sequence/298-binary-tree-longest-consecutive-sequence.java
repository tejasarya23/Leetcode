class Solution {   
    public int longestConsecutive(TreeNode root) {
        return helper(root,root.val+1,0,0)+1;
    }
    public int helper(TreeNode root,int prevval,int cur,int max){
        if(root==null){
            return max ;
        }
        if(root.val==prevval){
            cur++;
        }else{
            cur=0;
        }
        max=Math.max(cur,max);
        int l=helper(root.left,root.val+1,cur,max);
        int r=helper(root.right,root.val+1,cur,max);
        return Math.max(l,r);
    }
}
