class Solution {
    private int m, n;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] grid) {
	    Deque<int[]> q = new ArrayDeque<>();
        m = grid.length; n = grid[0].length;
        int res = 0;
        
        outer:
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1){//first connected component
                    dfs(grid, i, j, q);
                    break outer;
                }
        
        while(!q.isEmpty()){//BFS
            for(int i = q.size(); i > 0; i--){
                int[] curr = q.poll();
                
                for(int d[] : dirs){
                    int dx = curr[0] + d[0], dy = curr[1] + d[1];
                    if(dx < 0 || dy < 0 || dx >= m || dy >= n || grid[dx][dy] == 2)//out of bounds or already visited
                        continue;
                    
                    if(grid[dx][dy] == 1) return res;//found the second connected component 
                    
                    q.add(new int[]{ dx, dy });//add to queue
                    grid[dx][dy] = 2;//mark visited
                }
            }
            res++;
        }
        return -1;
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<int[]> q){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 2 || grid[i][j] == 0)//out of bounds or already visited or water
            return;
        
        grid[i][j] = 2;//mark visited
        q.add(new int[]{ i, j });//add to queue
        
        for(int d[] : dirs)//recurse
            dfs(grid, i + d[0], j + d[1], q);
    }
}
// class Solution {
//     int ans=500;int count=0;
//     public int shortestBridge(int[][] grid) {
//         boolean check[][] = new boolean[grid.length][grid[0].length];boolean found=false;
//         for(int i=0;i<grid.length&&found==false;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j]==1&&found==false){
//                     found=true;
//                     dfs(grid,check,i,j,count);
//                     break;
//                 }
//             }
//         }System.out.print(Arrays.deepToString(check));
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(check[i][j]==true){count=0;
//                     if(i>1&&check[i-1][j]==false)                 put(grid,check,i-1,j);
//                     if(i<grid.length-2&&check[i+1][j]==false)     put(grid,check,i+1,j);
//                     if(j>1&&check[i][j-1]==false)                 put(grid,check,i,j-1);
//                     if(j<grid[0].length-2&&check[i][j+1]==false)  put(grid,check,i,j+1);
//                 }
//             }
//         }
        
//         return ans;
//     }
//     public void put(int grid[][],boolean[][]check,int i , int j){
//         if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||check[i][j]==true){
//             return;
//         }
//         if(grid[i][j]==1&&check[i][j]==false) return;
//         grid[i][j]=1;check[i][j]=true;count++;
        
//         put(grid,check,i,j+1);
//         put(grid,check,i,j-1);
//         put(grid,check,i+1,j);
//         put(grid,check,i-1,j);
//         // int count=dfs(grid,check,i,j,0);
//         if(count>0){ans=Math.min(ans,count);}
//         grid[i][j]=0;check[i][j]=false;
        
//     }
//     public int dfs(int[][] grid,boolean[][]check,int i , int j,int count){
//         if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]==0||check[i][j]==true){
//             return 0;
//         }
//         check[i][j]=true;count++;
//         dfs(grid,check,i,j+1,count);
//         dfs(grid,check,i+1,j,count);
//         dfs(grid,check,i-1,j,count);
//         dfs(grid,check,i,j-1,count);
//         return count;
//     }
// }