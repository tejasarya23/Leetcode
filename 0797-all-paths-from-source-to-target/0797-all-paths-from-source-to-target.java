class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>path= new ArrayList<>();
        
        path.add(0);
        dfs(0,res,path,graph);
        
        return res;
    }
    public void dfs(int curnode,List<List<Integer>> res,List<Integer> path,int graph[][]){
        if(curnode==graph.length-1){
            res.add(new ArrayList<Integer>(path));
            return;
        }
      
        for(int curlist: graph[curnode]){
            path.add(curlist);
            dfs(curlist,res,path,graph);
            path.remove(path.size()-1);
        }
        return;
    }
}