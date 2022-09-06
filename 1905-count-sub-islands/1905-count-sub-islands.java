class Solution {
    int count=0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean check[][]=new boolean[grid1.length][grid1[0].length];boolean flag=true;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){
                if(grid2[i][j]==1&&check[i][j]==false){
                    // System.out.print(" i="+i+" j="+j);
                    flag=true;
                    
                    // dfs(grid1,grid2,check,i,j);
                    if(dfs(grid1,grid2,check,i,j,flag))count++;
                }
            }
        }
        // System.out.print(Arrays.deepToString(check));
        return count;
    }
    public boolean dfs(int[][] grid1,int[][] grid2,boolean[][]check,int i , int j,boolean flag){
        // System.out.print(" i="+i+" j="+j+" flag="+flag+"||");
        if(i<0||i>grid1.length-1||j<0||j>grid1[0].length-1||grid2[i][j]==0||check[i][j]==true){
            return true;
        }
        if(grid2[i][j]==1&&grid1[i][j]!=1){flag=false;check[i][j]=true;}
        // if(grid1[i][j]==1&&grid2 [i][j]==0){check[i][j]=true;count--;return;}

        check[i][j]=true;
        boolean a=dfs(grid1,grid2,check,i+1,j,flag);
        boolean b=dfs(grid1,grid2,check,i,j+1,flag);
        boolean c=dfs(grid1,grid2,check,i-1,j,flag);
        boolean d=dfs(grid1,grid2,check,i,j-1,flag);
        if(a&&b&&c&&d&&flag)return true;
        return false;
    }
}