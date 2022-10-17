class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;int max=0;
        for( int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int a=dfs(grid,n,m,i,j,0);
                    max=Math.max(max,a);
                }
            }
        }
        return max;
    }
    public int dfs(int grid[][],int n,int m ,int i , int j,int max){
        if(i<0 || j<0 || i>=n || j >=m || grid[i][j]==0){
            return max;
        }
        grid[i][j]=0;max++;
        max=dfs(grid,n,m,i+1,j,max);
        max=dfs(grid,n,m,i,j+1,max);
        max=dfs(grid,n,m,i-1,j,max);
        max=dfs(grid,n,m,i,j-1,max);
        
        return max;
    }
}