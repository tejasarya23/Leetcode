class Solution {
    public int findCircleNum(int[][] A) {
        int vis[]= new int [A.length];int count=0;
        for(int i=0;i<A.length;i++){
            if(vis[i]==0){dfs(A,i,vis);count++;}
        }
        return count;
    }
    public void dfs(int A[][],int person,int vis[]){

        for(int other = 0; other < A.length; other++) {
            if(A[person][other] == 1 && vis[other]==0) {
                //We found an unvisited person in the current friend cycle 
                vis[other] = 1;
                dfs(A, other,vis); //Start DFS on this new found person
            }
        }
    }
}