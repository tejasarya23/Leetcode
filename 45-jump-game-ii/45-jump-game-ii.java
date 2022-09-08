class Solution {
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
// class Solution {
//     public int jump(int[] nums) {
//         if(nums.length==1)return 0;
//         int dp[]= new int[nums.length];
//         int cur=0;
//         for(int i=0;i<=Math.min(nums.length-1,nums[0]);i++){
//             dp[i]=1;
//         }
//         // System.out.print(Arrays.toString(dp));
//         for(int i=1;i<nums.length;i++){
//             cur=dp[i];
//             for(int j=i;j<=Math.min(nums.length-1,i+nums[i]);j++){
//                 if(dp[j]==0){
//                     dp[j]=cur+1;
//                 }
//             }
//         }
//         // System.out.print(Arrays.toString(dp));
//         return dp[nums.length-1];
//     }
// }