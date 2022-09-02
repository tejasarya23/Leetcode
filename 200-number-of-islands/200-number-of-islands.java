class Solution {
    
    public int numIslands(char[][] grid) {
        int count=0;boolean check[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&&check[i][j]==false){
                    // System.out.print("hi");
                    dfs(grid,check,i,j);
                    count++;
                }
            }
        }
        System.out.print(Arrays.deepToString(check));
        return count;
    }
    public void dfs(char[][] grid,boolean[][]check,int i , int j){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]=='0'||check[i][j]==true){
            return;
        }
        check[i][j]=true;
        dfs(grid,check,i+1,j);
        dfs(grid,check,i,j+1);
        dfs(grid,check,i-1,j);
        dfs(grid,check,i,j-1);
    }
}