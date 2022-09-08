class Solution {
    public int jump(int[] nums) {
        
        if(nums.length == 1)
            return 0;
        
        if(nums[0] == 0)
            return -1;
        
        int maxReach = nums[0];
        int steps = nums[0];
        int jumps = 1;
        
        for(int i = 1 ; i< nums.length ; i++){
            
            if(i == nums.length - 1)
                return jumps;
            
            maxReach = Math.max(maxReach , i + nums[i]);
            steps--;
            if(steps == 0){
                jumps++;
                if(i >= maxReach)
                    return -1;
                
                steps = maxReach - i;
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