class Solution {   
    public int longestConsecutive(TreeNode root) {
        return helper(root,root.val+1,0);
    }
    public int helper(TreeNode root,int prevval,int cur){
        if(root==null){
            return cur ;
        }
        if(root.val==prevval){
            cur++;
        }else{
            cur=1;
        }
        // max=Math.max(cur,max);
        int l=helper(root.left,root.val+1,cur);
        int r=helper(root.right,root.val+1,cur);
        return Math.max(l,Math.max(r,cur));
    }
}
