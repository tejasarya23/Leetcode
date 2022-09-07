class Solution {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int step = 0;
        boolean found = false;
        Deque<int[]> queue = new ArrayDeque();
        
        // find one island
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        
        // BFS
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return step;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
            step++;
        }
        return step;
    }
    
    private void dfs(int[][] grid, int i, int j, Deque<int[]> queue) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        queue.add(new int[]{i, j});
        dfs(grid, i + 1, j, queue);
        dfs(grid, i - 1, j, queue);
        dfs(grid, i, j + 1, queue);
        dfs(grid, i, j - 1, queue);
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