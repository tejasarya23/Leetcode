class Solution {
    public int makeConnected(int n, int[][] edges){
        if(edges.length<n-1)return -1;
        Map<Integer, List<Integer>> parentToKids = new HashMap<>();
        for (int[] e : edges) {
            parentToKids.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            parentToKids.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }
        int vis[]= new int[n];
        int cmp=0;
        
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(parentToKids,vis,i);
                cmp++;
            }
        }
        // System.out.print(parentToKids);

        return cmp-1;
    }
    public void dfs(Map<Integer,List<Integer>> mp ,int vis[],int i){
        if(vis[i]==1){
            return;
        }
        vis[i]=1;
        for(int j : mp.getOrDefault(i,Arrays.asList())){
            dfs(mp,vis,j);
        }
    }
}