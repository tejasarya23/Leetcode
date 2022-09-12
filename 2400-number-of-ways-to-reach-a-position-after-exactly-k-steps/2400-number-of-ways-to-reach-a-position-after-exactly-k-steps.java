class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int dis=Math.abs(startPos-endPos);int mod=1000000007;
        int dp[][]= new int[Math.max(k+1,dis+1)][Math.max(k+1,dis+1)];
        
        // System.out.print(Arrays.deepToString(dp));
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(i==j){dp[i][j]=1;continue;}
                else if(i%2==0&&j%2!=0){dp[i][j]=0;continue;}
                else if(i%2!=0&&j%2==0){dp[i][j]=0;continue;}
                if(j==0){dp[i][j]=(dp[i-1][j+1]*2)%mod;continue;}
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
                                
            }
        }
        // System.out.print(Arrays.deepToString(dp));
        return dp[k][dis];
    }
}