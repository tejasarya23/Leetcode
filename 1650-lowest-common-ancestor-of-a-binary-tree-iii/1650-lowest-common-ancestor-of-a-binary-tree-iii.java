/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Map<Node,Integer> mp = new HashMap<>();
        while(p.parent!=null){
            mp.put(p,0);
            p=p.parent;
        }
        while(q.parent!=null){
            if(mp.containsKey(q)){
                return q;
            }
            q=q.parent;
        }
        return p;
    }
}