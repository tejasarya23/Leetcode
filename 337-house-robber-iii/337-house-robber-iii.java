class Solution {
    public int solve(TreeNode root,Map<TreeNode,Integer> mp) {
        if(root==null)return 0;
        if(mp.containsKey(root))return mp.get(root);
        int val=0;
        if(root.left!=null){
            val+=solve(root.left.left,mp)+solve(root.left.right,mp);
        }
        if(root.right!=null){
            val+=solve(root.right.left,mp)+solve(root.right.right,mp);
        }
        val=Math.max(val+root.val,(solve(root.left,mp)+solve(root.right,mp)));
        mp.put(root,val);
        return val;
    }
    public int rob(TreeNode root){
        return solve(root,new HashMap<>());        
    }
}