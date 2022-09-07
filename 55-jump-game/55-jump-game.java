class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reachable=0;
        for(int i=0;i<n;i++){
            if(reachable<i){
                return false;
            }
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }
    // public boolean canJump(int[] nums) {
    //     if(nums.length==1)return true;
    //     boolean check[]=new boolean[nums.length];check[0]=true;
    //     int lst=nums[0];
    //     if(lst>=nums.length)lst=nums.length-1;
    //     for(int i=0;i<=lst;i++){
    //         check[i]=true;
    //     }
    //     // System.out.print(Arrays.toString(check));
    //     for(int i=1;i<nums.length-1;i++){
    //         if(check[i]==true){
    //             // System.out.print(Arrays.toString(check));
    //             int last=i+1+nums[i];
    //             if(last>nums.length)last=nums.length;
    //             for(int j=i+1;j<last;j++){
    //                 check[j]=true;
    //                 // System.out.print(j);
    //                 // System.out.print(Arrays.toString(check));
    //             }
    //         }
    //     }
    //     // System.out.print(Arrays.toString(check));
    //     return check[nums.length-1];
    // }
}