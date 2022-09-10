class Solution {
    // public int maximalSquare(char[][] matrix) {
    //     int dp[][]= new int[matrix.length][matrix[0].length];
    //     if(matrix[0][0]=='1')dp[0][0]=1;
    //     for(int i=1;i<matrix.length;i++){
    //         if(matrix[i][0]=='1')
    //             dp[i][0]=1;
    //         else dp[i][0]=dp[i-1][0];
    //     }
    //     for(int i=1;i<matrix[0].length;i++){
    //         if(matrix[0][i]=='1')
    //             dp[0][i]=1;
    //         else dp[0][i]=dp[0][i-1];
    //     }
    //     for(int i=1;i<matrix.length;i++){
    //         for(int j=1;j<matrix[0].length;j++){
    //             if(matrix[i][j]=='1'){
    //                 if(matrix[i-1][j]==matrix[i][j-1]&&matrix[i][j-1]==matrix[i-1][j-1]){
    //                     if(dp[i-1][j]==dp[i][j-1])dp[i][j]=1+dp[i-1][j];
    //                     else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    //                 }else{
    //                     dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i][j-1]));
    //                 }
    //             }else{
    //                 dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i][j-1]));
    //             }
    //         }
    //     }
    //     // System.out.print(Arrays.deepToString(dp));
    //     return dp[matrix.length-1][matrix[0].length-1]*dp[matrix.length-1][matrix[0].length-1];
    // }
    public int maximalSquare(char[][] matrix) {
      if(matrix.length == 0) return 0;
      int m = matrix.length, n = matrix[0].length;
      int[][] dp = new int[m + 1][n + 1];
   
      int edge = 0;      
      for(int i = 1; i <= m; i++){
        for(int j = 1; j <= n; j++){
          if(matrix[i - 1][j - 1] == '1'){
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
            edge = Math.max(edge, dp[i][j]);
          }
        }
      }
      
      return edge * edge;  
    }
}